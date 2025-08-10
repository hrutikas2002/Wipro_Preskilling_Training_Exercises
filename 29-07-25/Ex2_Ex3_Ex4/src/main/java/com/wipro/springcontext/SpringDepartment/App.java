package com.wipro.springcontext.SpringDepartment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wipro.springcontext.SpringDepartment.beans.College;
import com.wipro.springcontext.SpringDepartment.beans.Department;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        
        College college = (College) context.getBean("college");
		System.out.println(college);
    }
}
