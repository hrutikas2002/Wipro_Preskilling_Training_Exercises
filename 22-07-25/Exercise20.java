package com.wipro.basic;

import java.util.Arrays;

//String Anagram: Check if two strings are anagrams (contain the same characters in a different order).

public class Exercise20 {
	public static void main(String[] args) {
		String str1 = "Listen";
		String str2 = "Silent";
		
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		if (str1.length() != str2.length()) {
			System.out.println("Not Anagrams");
			return;
		}
		
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();

		// Sort both arrays
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		// Compare sorted arrays
		if (Arrays.equals(arr1, arr2)) {
			System.out.println("Anagrams");
		} else {
			System.out.println("Not Anagrams");
		}
	}
}
