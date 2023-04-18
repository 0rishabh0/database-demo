--create table person
--(
-- id integer not null,
-- name varchar(255) not null,
-- location varchar(255),
-- birth_date timestamp,
-- primary key(id)
--);

--Above DDL commented since Jpa will now auto create the schema for us

INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(10001,  'Ranga', 'Hyderabad',now());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(10002,  'James', 'New York',now());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(10003,  'Pieter', 'Amsterdam',now());