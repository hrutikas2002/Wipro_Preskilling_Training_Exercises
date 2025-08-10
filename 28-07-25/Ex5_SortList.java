package com.wipro.methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortList {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Rutika","Vedant","Srushti","Dipti","Yash","Nitish");
		
		
		List<String> sortedNames = names.stream()
				.sorted(String::compareTo)
				.collect(Collectors.toList()); 
		
		System.out.println("Sorted list of names: ");
		
		sortedNames.forEach(System.out::println);
	}
}
