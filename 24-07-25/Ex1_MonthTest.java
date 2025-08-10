package com.wipro.test;

import java.util.Scanner;

import com.wipro.exception.InvalidMonthException;

public class MonthTest 
{
	public static void checkMonth(int month) throws InvalidMonthException 
	{
		if((month<1) || (month>12)) {
			throw new InvalidMonthException("Invalid Month!");
		}
		else {
			System.out.println("Month:"+month);
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter month number: ");
		int month = sc.nextInt();
		try {
			checkMonth(month);
		}catch(InvalidMonthException ex) {
			System.out.println("Exception: "+ex.getMessage());
		}
	}
}
