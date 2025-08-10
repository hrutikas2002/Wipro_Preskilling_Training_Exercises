package com.wipro.jparelationship.service;

import java.util.List;

import com.wipro.jparelationship.entity.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
}
