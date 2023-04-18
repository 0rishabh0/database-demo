package com.in28minutes.jdbc.databasedemo.jpa;

import com.in28minutes.jdbc.databasedemo.entity.Person;
import com.in28minutes.jdbc.databasedemo.entity.PersonEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//Repository
@Transactional//Transaction
public class PersonJpaRepository {

    //connect to database
    @PersistenceContext // all operations defined in PersistenceContext , EntityManager is the interface to the PersistenceContext
    EntityManager entityManager;

    public List<PersonEntity> findAll(){
        TypedQuery<PersonEntity> namedQuery= entityManager.createNamedQuery("find_all_persons", PersonEntity.class);
        return namedQuery.getResultList();
    }

    public PersonEntity findById(int id){
        return entityManager.find(PersonEntity.class, id); //JPA
    }

    public PersonEntity update(PersonEntity person){
        return entityManager.merge(person); //here instead of update we have merge , hibernate will automatically do insert/update on our behalf
    }

    public PersonEntity insert(PersonEntity person){
        return entityManager.merge(person);
    }

    public void deleteById(int id){
         PersonEntity person = findById(id); // need to get the entity out by using id first
         entityManager.remove(person);
    }
}
