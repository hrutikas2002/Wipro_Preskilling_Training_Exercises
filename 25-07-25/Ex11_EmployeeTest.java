package com.wipro.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.wipro.functionalinterface.Employee;

public class EmployeeTest {
	public static void main(String[] args) {
		Employee e1 = new Employee("EMP123","Rutika",22,90000.0);
		Employee e2 = new Employee("EMP124", "Ankit", 25, 60000.0);
		Employee e3 = new Employee("EMP125", "Sneha", 24, 45000.0);
		Employee e4 = new Employee("EMP126", "Raj", 26, 85000.0);
		
		List<Employee> list = new ArrayList<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		
		Comparator<Employee> salaryComparator = (emp1, emp2) -> Double.compare(emp1.getSalary(), emp2.getSalary());
		
		Collections.sort(list, salaryComparator);
		System.out.println(list);
	}
}
