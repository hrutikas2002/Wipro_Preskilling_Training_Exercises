package com.wipro.methodreference;

import java.util.ArrayList;
import java.util.List;

public class AverageSalary {
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();

		Employee e1 = new Employee("John", 25, 40000);
		Employee e2 = new Employee("Alice", 35, 60000);
		Employee e3 = new Employee("Bob", 40, 70000);
		Employee e4 = new Employee("Charlie", 20, 30000);
		Employee e5 = new Employee("David", 38, 55000);

		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);

		double average = list.stream()
				.filter(e -> e.getAge() > 30 && e.getSalary() > 50000)
				.mapToDouble(Employee::getSalary)
				.average()
				.orElse(0.0); 
		
		System.out.println("Average Salary of Employees with age > 30 and salary > 50000: " + average);
	}
}
