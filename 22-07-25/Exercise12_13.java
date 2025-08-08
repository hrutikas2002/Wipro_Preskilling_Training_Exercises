package com.wipro.basic;

//Find out the largest number in  the following array {100,67,98,678,45,123}
//Find the second largest element in an array of integers.
//Input: An integer array arr.
//Output: The second largest element in the array.
//Example:
//Input: [10, 5, 20, 8, 15]
//Output: 15

public class Exercise12_13 
{
	public static void main(String[] args) {
		int[] numbers = {100,97,98,678,45,123};

		int max = numbers[0];
		int secondLarge = numbers[0];

		for(int i = 0;i<numbers.length;i++) 
		{
			if(numbers[i]>max)
			{
				secondLarge = max;
				max = numbers[i];
			}
			else if (numbers[i]>secondLarge && numbers[i]!=max) 
			{
				secondLarge=numbers[i];
			};
			
		}
		System.out.println("Largest number: "+max);
		if (max == secondLarge) {
            System.out.println("No second largest number.");
        } else {
            System.out.println("Second largest number: " + secondLarge);
        }
	}
}
