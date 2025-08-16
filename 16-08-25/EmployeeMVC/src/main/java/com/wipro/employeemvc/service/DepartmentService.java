package com.wipro.employeemvc.service;

import java.util.List;
import java.util.Optional;

import com.wipro.employeemvc.entity.Department;

public interface DepartmentService {
	public List<Department> findAll();
	public Department save(Department department);
	public Optional<Department> findById(Long id);
}
