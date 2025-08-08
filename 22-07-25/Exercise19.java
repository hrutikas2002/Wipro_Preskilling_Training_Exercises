package com.wipro.basic;

public class Exercise19 {
	public static void main(String[] args) {
		String s = "rotor";
		
		StringBuilder reversed = new StringBuilder();
		
		for (int i = s.length() - 1; i >= 0; i--) {
			reversed.append(s.charAt(i));
		}

		// Compare original and reversed strings
		if (s.equals(reversed.toString())) {
			System.out.println(s + " is a palindrome.");
		} else {
			System.out.println(s + " is not a palindrome.");
		}
	}
}
