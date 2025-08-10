package com.wipro.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {
	public static void main(String[] args) {
		List <Integer> list = new ArrayList<>();

		list.add(10);
		list.add(20);
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		System.out.println("List: "+list);
		Set<Integer> newList = new HashSet<>(list);
		List<Integer> resultList = new ArrayList<>(newList);
		System.out.println("After removing duplicates: "+resultList);
	}
}
