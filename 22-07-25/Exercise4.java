package com.wipro.basic;

public class conditionalStatements1 {
	public static void main(String[] args) {
		char shape = 'C';
		
		if(shape == 'R') {
			System.out.println("shape is Rectangle.");
		}
		else if(shape=='C') {
			System.out.println("Shape is Circle.");
		}
		else if(shape=='S') {
			System.out.println("Shape is square");
		}
		else {
			System.out.println("Other shape");
		}
	}
}
