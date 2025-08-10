package com.wipro.jparelationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.jparelationship.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long>{

}
