package com.wipro.jparelationship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.jparelationship.entity.Person;
import com.wipro.jparelationship.repository.PersonRepo;

@Service
public class PersonServiceImpl implements PersonService{
	 @Autowired
	    private PersonRepo personRepo;

	    @Override
	    public Person savePerson(Person person) {
	        return personRepo.save(person);
	    }

	    @Override
	    public List<Person> getAllPersons() {
	        return personRepo.findAll();
	    }
}
