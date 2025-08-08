package com.wipro.basic;

//duplicates from a sorted array and return the length of the resulting array.
//Input: A sorted integer array arr.
//Output: Length of the array after removing duplicates.
//Example:
//Input: [1, 1, 2, 2, 3, 4, 4, 5]
//Output: 5 (resulting array: [1, 2, 3, 4, 5])

public class Exercise14 
{
	public static void main(String[] args) {
		int[] numbers = {1, 1, 2, 2, 3, 4, 4, 5};

		int[] newNumbers = new int[numbers.length];
		int index = 0;

		for(int i = 0;i<numbers.length;i++) {
			boolean flag = true;

			for(int j = 0;j<index;j++) {
				if(numbers[i]==newNumbers[j]) {
					flag=false;
					break;
				}
			}
			
			if(flag==true) {
				newNumbers[index]=numbers[i];
				index++;
			}
		}

		System.out.println("Length after removing duplicates: "+index);

		System.out.println("New Array: ");
		for(int k = 0;k<index;k++) {
			System.out.print(newNumbers[k]+" ");
		}

	}
}
