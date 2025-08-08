package com.wipro.exception;

import java.util.Scanner;

public class CurrencyConverter 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number:");
		int n = sc.nextInt();
		try 
		{
            int convertedCurrency = changeCurrency(n);
            System.out.println("Converted Amount: " + convertedCurrency);
        } 
		catch (NumberFormatException ex) 
		{
            System.out.println("Exception: " + ex.getMessage());
        }
	}
	
	public static int changeCurrency(int number) throws NumberFormatException 
	{
        if (number == 0) 
        {
            throw new NumberFormatException("Invalid Number");
        } 
        else 
        {
            return number * 80;
        }
    }
}
