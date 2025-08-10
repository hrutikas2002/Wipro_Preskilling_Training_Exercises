package com.wipro.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.wipro.collection.Employee;
import com.wipro.collection.SortByAge;
import com.wipro.collection.SortById;
import com.wipro.collection.SortByName;
import com.wipro.collection.SortBySalary;

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
		
		System.out.println("Sorting by id: ");
		Collections.sort(list,new SortById());
		System.out.println(list);
		
		System.out.println("Sorting by name: ");
		Collections.sort(list,new SortByName());
		System.out.println(list);
		
		System.out.println("Sorting by salary: ");
		Collections.sort(list,new SortBySalary());
		System.out.println(list);
		
		System.out.println("Sorting by age: ");
		Collections.sort(list,new SortByAge());
		System.out.println(list);
		
		CopyOnWriteArrayList<Employee> list1 = new CopyOnWriteArrayList<>();
        list1.add(e1);
        list1.add(e2);
        list1.add(e3);
        list1.add(e4);
        
        for (Employee emp : list1) {
            if (emp.getSalary() > 80000) {
                list1.remove(emp);
            }
        }
        
        System.out.println("\n\nEmployees with salary greater than 80000 removed. New List: ");
        System.out.println(list1);
	}
}
