package com.wipro.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.wipro.thread.ChangeCase;

public class ChangeCaseTest {
	public static void main(String[] args) {
		
	        List<String> names = new ArrayList<>(
	            Arrays.asList("Amit", "Yash", "Om", "Neha", "Aditya", "Nitish", "Ishita")
	        );

	        ChangeCase c1 = new ChangeCase(names);
	        c1.change();

	        System.out.println("Final Names List: " + c1.getNewNames());
	    
	}
}
