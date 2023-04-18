package com.in28minutes.jdbc.databasedemo;

import com.in28minutes.jdbc.databasedemo.entity.Person;
import com.in28minutes.jdbc.databasedemo.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override  // implemented from CommandLineRunner
	public void run(String... args) throws Exception {
//		List<Person> personList = dao.findAll();
//		for(Person person:personList) {
//			logger.info("Person ",person.getName());
//		}
		logger.info("All users -> {}",dao.findAll());
		logger.info("Person with id 10001 -> {}",dao.findById(10001));
		logger.info("Person living in Hyderabad -> {}", dao.findByLocation("Hyderabad"));
		logger.info("Deleting 10002 -> no of Rows deleted - {}", dao.deleteById(10002));
		logger.info("inserting 10004 -> {}", dao.insert(new Person(10004,"Rishabh", "Bengaluru",new Date())));
		logger.info("Update 10003 -> {}", dao.update(new Person(10003,"Ricky", "Gorakhpur",new Date())));
	}
}
