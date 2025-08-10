package com.wipro.jparelationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.jparelationship.entity.Person;

public interface PersonRepo extends JpaRepository<Person, Long>{

}
