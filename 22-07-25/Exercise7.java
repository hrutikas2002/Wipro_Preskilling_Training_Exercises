package com.wipro.basic;

public class Exercise7 {
	public static void main(String[] args) {
		float num1 = 25.586f;
		float num2 = 25.589f;
		
		int round1 = Math.round(num1*1000);
		int round2 = Math.round(num2*1000);

		if(round1==round2) 
		{
			System.out.println("Same");
		} 
		else 
		{
			System.out.println("Different");
		}
	}
}
