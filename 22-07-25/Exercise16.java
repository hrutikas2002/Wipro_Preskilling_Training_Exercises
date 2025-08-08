package com.wipro.basic;

//Reverse an array in place without using an extra array.
//Input: An integer array arr.
//Output: Array reversed in place.
//Example:
//Input: [1, 2, 3, 4, 5]
//Output: [5, 4, 3, 2, 1]

public class Exercise16 {
	public static void main(String[] args) {
		int[] num = {1, 2, 3, 4, 5};
		
		for(int i = 0;i<num.length/2;i++) {
			int t = num[i];
			num[i] = num[num.length-1-i];
			num[num.length-1-i]=t;
		}
		
		for(int j = 0;j<num.length;j++) {
			System.out.print(num[j]+" ");
		}
	}
}
