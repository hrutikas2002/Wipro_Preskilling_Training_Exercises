package com.wipro.basic;

//Count Vowels and Consonants: Count the number of vowels and consonants in a given string.

public class Exercise21 
{
	public static void main(String[] args) {
		String name = "Rutika";

		int vowelCount = 0;
		int consonantCount = 0;
		
		name = name.toLowerCase();

		for (int i = 0; i < name.length(); i++) 
		{
			
			char ch = name.charAt(i);
			
			if (ch>='a' && ch<='z') 
			{
				if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') 
				{
					vowelCount++;
				}
				else 
				{
					consonantCount++;
				}
			}
		}
		
		System.out.println("Vowel count: "+vowelCount);
		System.out.println("Consonant count: "+consonantCount);
	}
}
