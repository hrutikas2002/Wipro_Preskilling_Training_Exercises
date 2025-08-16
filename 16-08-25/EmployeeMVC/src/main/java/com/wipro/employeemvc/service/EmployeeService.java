package com.wipro.employeemvc.service;

import java.util.List;
import java.util.Optional;

import com.wipro.employeemvc.entity.Employee;

public interface EmployeeService {
	public Employee save(Employee employee);
	public List<Employee> findAll();
	public Optional<Employee> findById(Long id);
	public void deleteById(Long id);
}
