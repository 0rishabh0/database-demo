package com.in28minutes.jdbc.databasedemo.entity;


import jakarta.persistence.*;

import java.util.Date;

//Jpa will know that from @Entity that it is a table and will try to create the table schema by itself, so now we don't need to define table person in data.sql

@Entity
@Table(name = "person")   // to match PersonEntity with the person table, had this been done to the Person class we won't need to explicitly specify the table name
                          // since the class name and table name exactly match in that case
@NamedQuery(name="find_all_persons", query ="select p from PersonEntity p") // this is an example of jpql(java persistence query language) where in it doesn't
                                                                            // need to interact with the tables rather the entities

public class PersonEntity {

    @Id
    @GeneratedValue           // For auto assigning values to the field(here id) by hibernate
    private int id;
    private String name;
    private String location;
    private Date birthDate;

    public PersonEntity() {
        // need to provide a no argument constructor for BeanFactoryRowMapper to work properly
    }

    public PersonEntity(int id, String name, String location, Date birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public PersonEntity(String name, String location, Date birthDate) {
        // we need a constructor with no id args since id will be auto generated
        super();
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
