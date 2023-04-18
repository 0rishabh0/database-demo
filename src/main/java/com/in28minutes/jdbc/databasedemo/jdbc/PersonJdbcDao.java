package com.in28minutes.jdbc.databasedemo.jdbc;

import com.in28minutes.jdbc.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.List;

@Repository   // this annotation since the specified class is handling data
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;    // template provided by jdbc

    //A Custom RowMapper Explicitly defining a row mapping from h2 table to Person class fields
    class PersonRowMapper implements RowMapper<Person>{
        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException{
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirthDate(rs.getTimestamp("birth_date"));
            return person;
        }
    }

    //select * from person
//    public List<Person> findAll(){
//        return jdbcTemplate.query("select * from person",new BeanPropertyRowMapper<Person>(Person.class)); // Auto mapping the fields in person table to the fields defined in Person class
//    }

    public List<Person> findAll(){
        return jdbcTemplate.query("select * from person",new PersonRowMapper()); // Auto mapping the fields in person table to the fields defined in Person class
    }

    public Person findById(int id){
//        System.out.println(jdbcTemplate.queryForObject("select * from person where id = ?",new BeanPropertyRowMapper<Person>(Person.class),id));
        return jdbcTemplate.queryForObject("select * from person where id = ?",new BeanPropertyRowMapper<Person>(Person.class),id);
    }

    public Person findByLocation(String location){
        return jdbcTemplate.queryForObject("select * from person where location = ?", new BeanPropertyRowMapper<Person>(Person.class), location);
    }

    public int deleteById(int id){
        return jdbcTemplate.update("delete from person where id = ?",id);
    }

    public int insert(Person person){
        return jdbcTemplate.update(
                "insert into person (id, name, location, birth_date )"
                        + " values(?, ?, ?, ?)",
                new Object[]{person.getId(),person.getName(),person.getLocation(), new Timestamp(person.getBirthDate().getTime())});
    }


    public int update(Person person){
        return jdbcTemplate.update(
                "update person "
                        + " set name = ?, location = ?, birth_date = ? "
                        + " where id = ? ",
                new Object[]{person.getName(),person.getLocation(), new Timestamp(person.getBirthDate().getTime()),person.getId()});
    }

}
