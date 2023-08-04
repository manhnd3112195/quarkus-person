package com.example.quarkus.resources;

import com.example.quarkus.entities.Person;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    @GET
    public List<Person> getAll() {
        return PanacheEntityBase.findAll(Sort.ascending("lastName")).list();
    }

    @POST
    @Transactional
    public Response create(Person p) {
        if (p == null || p.getId() != null) {
            throw new WebApplicationException("Person id must be null", Response.Status.BAD_REQUEST);
        }
        p.persist();
        return Response.ok(p).status(Response.Status.OK).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Person update(@PathParam("id") Long id, Person p) {
        Person entity = PanacheEntityBase.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Person with id of " + id + " does not exist.", Response.Status.NOT_FOUND);
        }
        if (p.getSalutation() != null) {
            entity.setSalutation(p.getSalutation());
        }
        if (p.getFirstName() != null) {
            entity.setFirstName(p.getFirstName());
        }
        if (p.getLastName() != null) {
            entity.setLastName(p.getLastName());
        }
        return entity;
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Person entity = PanacheEntityBase.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Person with id of " + id + " does not exist.", Response.Status.NOT_FOUND);
        }
        entity.delete();
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
