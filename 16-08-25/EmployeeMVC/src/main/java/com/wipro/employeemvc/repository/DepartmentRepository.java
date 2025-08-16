package com.wipro.employeemvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.employeemvc.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
