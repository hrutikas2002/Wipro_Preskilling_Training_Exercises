package com.wipro.datetime;

//Create a Local date object for 1st November 2023 and print it like 01-11-2023

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Exercise10 {
	public static void main(String[] args) 
	{
		LocalDate date = LocalDate.of(2023, 11, 1);

		String afterFormat = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		
		System.out.println(afterFormat);
	}
}
