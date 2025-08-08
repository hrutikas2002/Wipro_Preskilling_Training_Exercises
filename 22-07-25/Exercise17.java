package com.wipro.basic;

//Exercise 17:
//Create an enum called Month having values like JANUARY,FEBRURAY…DECEMBER
//Using for each print all the possible Month values.

//Create a variable coalled month of Type Month assignFEBRURAY to it and check using if condition if the assigned month isFEBRURAY or not.


public class Exercise17 {
	public static void main(String[] args) {
		enum Month{
			january, February, march, april, may, june, july, august, september, october, november, december
		}
		
		for(Month m: Month.values()) {
			System.out.println(m);
		}
		
		Month month = Month.February;

		if (month == Month.February) {
			System.out.println("The month is FEBRUARY.");
		} else {
			System.out.println("The month is not FEBRUARY.");
		}
	}
}
