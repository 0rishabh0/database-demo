package com.in28minutes.jdbc.databasedemo;

import com.in28minutes.jdbc.databasedemo.entity.PersonEntity;
import com.in28minutes.jdbc.databasedemo.jpa.PersonJpaRepository;
import com.in28minutes.jdbc.databasedemo.springdata.PersonSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonSpringDataRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override  // implemented from CommandLineRunner
	public void run(String... args) throws Exception {
		logger.info("Person with id 10001 -> {}", repository.findById(10001));
		logger.info("inserting 10004 -> {}", repository.save(new PersonEntity("Rishabh", "Bengaluru",new Date()))); // JpaRepository has 'save' instead of merge, insert or update
		logger.info("Update 10003 -> {}", repository.save(new PersonEntity(10003,"Ricky", "Gorakhpur",new Date())));
		repository.deleteById(10002);
		logger.info("All users -> {}", repository.findAll());
	}
}
