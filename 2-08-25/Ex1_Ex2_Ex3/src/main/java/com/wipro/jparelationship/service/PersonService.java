package com.wipro.jparelationship.service;

import java.util.List;

import com.wipro.jparelationship.entity.Person;

public interface PersonService {
	Person savePerson(Person person);
    List<Person> getAllPersons();
}
