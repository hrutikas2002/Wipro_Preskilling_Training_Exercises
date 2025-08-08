package com.wipro.basic;

public class conditionalStatements1 {
	public static void main(String[] args) {
		char shape = 'C';
				
		switch (shape) {
		case 'R': {
			System.out.println("Rectangle");
			break;
		}
		case 'C': {
			System.out.println("Circle");
			break;
		}
		case 'S': {
			System.out.println("Square");
			break;
		}
		case 'O': {
			System.out.println("Other Shape");
			break;
		}
		default:
			System.out.println("Something is wrong.");
		}
	}
}
