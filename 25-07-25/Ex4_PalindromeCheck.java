package com.wipro.functionalinterface;

import java.util.function.Predicate;

public class PalindromeCheck {
	public static void main(String[] args) 
	{
		Predicate<String> isPalindrome = str -> 
		{
			return str.equalsIgnoreCase(new StringBuilder(str).reverse().toString());
		};

		String input1 = "rotor";
		String input2 = "predicate";

		System.out.println(isPalindrome.test(input1)); 
		System.out.println(isPalindrome.test(input2));
	}
}
