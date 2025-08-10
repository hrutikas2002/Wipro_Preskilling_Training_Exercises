package com.wipro.functionalinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ListElementsLength {
	public static void main(String[] args) {
		 List<String> names = Arrays.asList("Rutika", "Vedu", "Sujit", "Yash");
		 
		 Function<List<String>, List<Integer>> length = nameList -> 
		 {
	            List<Integer> lengthArr = new ArrayList<>();
	            for (String s : nameList) 
	            {
	            	lengthArr.add(s.length());
	            }
	            return lengthArr;
	        };

	        List<Integer> result = length.apply(names);

	        System.out.println(result); 
	}
}
