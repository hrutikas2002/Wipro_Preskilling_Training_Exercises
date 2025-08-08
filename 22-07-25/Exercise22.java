package com.wipro.basic;

//Find Shortest Word in a String: Identify the shortest word in a string.
public class Exercise22 
{
	public static void main(String[] args) {
		String sentence = "find shortest word";

		String[] words = sentence.split(" ");

		String shortest = words[0];

		for (String word : words) {
			if (word.length() < shortest.length()) {
				shortest = word;
			}
		}
		
		System.out.println("Shortest word: " + shortest);
	}
}
