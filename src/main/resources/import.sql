CREATE TABLE person (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
	salutation VARCHAR(255)
);

insert into person(first_name, last_name, salutation) values ('Doro', 'Pesch', 'Mrs');
insert into person(first_name, last_name, salutation) values ('Bobby', 'Brown', 'Mr');
insert into person(first_name, last_name, salutation) values ('Curt', 'Cobain', 'Mr');
insert into person(first_name, last_name, salutation) values ('Nina', 'Hagen', 'Mrs');
insert into person(first_name, last_name, salutation) values ('Jimmi', 'Henrix', 'Mr');
insert into person(first_name, last_name, salutation) values ('Janis', 'Joplin', 'Mrs');
insert into person(first_name, last_name, salutation) values ('Joe', 'Cocker', 'Mr');
insert into person(first_name, last_name, salutation) values ('Alice', 'Cooper', 'Mr');
insert into person(first_name, last_name, salutation) values ('Bruce', 'Springsteen', 'Mr');
insert into person(first_name, last_name, salutation) values ('Eric', 'Clapton', 'Mr');