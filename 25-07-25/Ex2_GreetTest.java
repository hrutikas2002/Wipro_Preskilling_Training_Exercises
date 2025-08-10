package com.wipro.test;
import com.wipro.anonymousclass.*;
import com.wipro.functionalinterface.Greet;

public class GreetTest 
{
	public static void main(String[] args) {
		Greet g = () ->  System.out.println("Hello Lambda!");
		g.sayHello();
	}
}
