package com.wipro.basic;

public class Exercise11 
{
	public static void main(String[] args) {
		int [] numbers = {10,20,30,40,100};
		
		for(int i = 0; i<numbers.length;i++) {
			numbers[i]=numbers[i]*2;
		}
		
		for(int j = 0;j<numbers.length;j++) {
			System.out.print(numbers[j]+ " ");
		}
	}
}
