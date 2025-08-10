package com.wipro.datetime;

import java.time.LocalDate;

public class CheckLeapYear 
{
	public static void leapCheck(LocalDate date) 
	{
		int year = date.getYear();

		if ((year%4==0 && year%100 != 0) || (year%400==0)) 
		{
			System.out.println(year+" is a Leap Year.");
		} 
		else 
		{
			System.out.println(year+" is not a Leap Year.");
		}
	}

	public static void main(String[] args) 
	{
		LocalDate date = LocalDate.of(2004,5,15);
		leapCheck(date);
	}
}
