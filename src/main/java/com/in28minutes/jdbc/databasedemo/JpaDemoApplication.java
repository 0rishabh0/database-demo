package com.in28minutes.jdbc.databasedemo;

import com.in28minutes.jdbc.databasedemo.entity.Person;
import com.in28minutes.jdbc.databasedemo.entity.PersonEntity;
import com.in28minutes.jdbc.databasedemo.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override  // implemented from CommandLineRunner
	public void run(String... args) throws Exception {
//		List<Person> personList = dao.findAll();
//		for(Person person:personList) {
//			logger.info("Person ",person.getName());
//		}

		logger.info("Person with id 10001 -> {}", repository.findById(10001));
//		logger.info("Person living in Hyderabad -> {}", repository.findByLocation("Hyderabad"));
//		logger.info("Deleting 10002 -> no of Rows deleted - {}", repository.deleteById(10002));
		logger.info("inserting 10004 -> {}", repository.insert(new PersonEntity("Rishabh", "Bengaluru",new Date()))); // since hibernate will auto assign
		// ids we don't need to pass ids in constructor when inserting a value
		logger.info("Update 10003 -> {}", repository.update(new PersonEntity(10003,"Ricky", "Gorakhpur",new Date())));
		repository.deleteById(10002);
		logger.info("All users -> {}", repository.findAll());
	}
}
