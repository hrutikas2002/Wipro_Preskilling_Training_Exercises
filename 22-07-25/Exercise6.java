package com.wipro.basic;

public class ConditionalStatements2 {
	public static void main(String[] args) {
		float number = -1000001f;
		
		if (number == 0) 
		{
            System.out.println("Zero");
        } 
		else 
		{
            if (number > 0) 
            {
                System.out.print("Positive");
            } else {
                System.out.print("Negative");
            }

            double absValue = Math.abs(number);
            
            if (absValue < 1) 
            {
                System.out.println(" and small");
            } 
            else if (absValue > 1000000) 
            {
                System.out.println(" and large");
            } 
            else 
            {
                System.out.println();
            }
        }
	}
}
