package com.wipro.jparelationship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.jparelationship.entity.Department;
import com.wipro.jparelationship.entity.Employee;
import com.wipro.jparelationship.repository.DepartmentRepo;
import com.wipro.jparelationship.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepository;

	@Autowired
	private DepartmentRepo departmentRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		Department dept = employee.getDept();
		if (dept != null && dept.getId() == null) {
			dept = departmentRepository.save(dept);
			employee.setDept(dept);
		}
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}	
}
