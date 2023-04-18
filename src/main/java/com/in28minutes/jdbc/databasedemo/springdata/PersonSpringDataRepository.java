package com.in28minutes.jdbc.databasedemo.springdata;

import com.in28minutes.jdbc.databasedemo.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSpringDataRepository extends JpaRepository<PersonEntity,Integer> {
}
