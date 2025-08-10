package com.wipro.test;

import com.wipro.functionalinterface.Multiply;

public class MultiplyTest {
	public static void main(String[] args) 
	{
		Multiply m = (a,b) -> a*b;
		
		int result = m.multiply(10, 20);
		System.out.println("Multiplication Result: "+result);
	}
}
