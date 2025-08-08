package com.wipro.basic;

//Print summation of all even numbers between 1 to 100 

public class Exercise10
{
	public static void main(String[] args) {
		int i = 0;
		int sum =0;
		while(i <=100) {
			sum = sum+i;
			i=i+2;
		}
		System.out.println("Summation of even numbers from 0 to 100: "+sum);
	}
}
