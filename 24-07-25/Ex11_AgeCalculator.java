package com.wipro.datetime;

import java.time.LocalDate;

public class AgeCalculator
{
	public static int getAge(LocalDate birthDate) 
	{
        LocalDate currentDate = LocalDate.now();
        return currentDate.getYear()-birthDate.getYear();
    }
	
	public static void main(String[] args) 
	{
		 LocalDate birthDate = LocalDate.of(2006,6,23);
		 
		 int age = getAge(birthDate);
		 System.out.println("Age(in Years): "+age);
	}
}
