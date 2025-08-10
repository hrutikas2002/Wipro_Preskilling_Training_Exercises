package com.wipro.functionalinterface;

import java.util.function.Predicate;

public class CheckCase {
	public static void main(String[] args) 
	{
		Predicate<String> isUpperCase = str -> str.equals(str.toUpperCase());
		Predicate<String> isLowerCase = str -> str.equals(str.toLowerCase());

		String input = "rutika";

		String result = isUpperCase.test(input) ? 
				"uppercase" :isLowerCase.test(input) ? 
				"lowercase" :"uppercase as well as";

		System.out.println("String is in "+ result);
	}
}
