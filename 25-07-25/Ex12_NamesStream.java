package com.wipro.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NamesStream {
	public static void main(String[] args) {
		List<String> nameList = Arrays.asList("Jayanta", "Amit", "Rutika", "Rajandra", "Jayesh");

        List<String> result = nameList.stream()
            .filter(name -> name.toLowerCase().contains("ja"))
            .collect(Collectors.toList());	

        System.out.println(result);
	}
}
