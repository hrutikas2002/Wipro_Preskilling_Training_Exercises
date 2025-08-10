package com.wipro.jparelationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.jparelationship.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
