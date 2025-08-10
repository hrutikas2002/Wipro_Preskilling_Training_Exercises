package com.wipro.springcontext.SpringDepartment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.wipro.springcontext.SpringDepartment.beans.Mobile;

@Configuration
@ComponentScan("com.wipro.springcontext.SpringDepartment.beans")
public class App2 {
public static void main(String[] args) {
	ApplicationContext apx = new AnnotationConfigApplicationContext(App2.class);
	Mobile mobile = apx.getBean(Mobile.class);
    System.out.println(mobile);
}
}
