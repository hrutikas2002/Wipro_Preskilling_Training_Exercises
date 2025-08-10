package com.wipro.collection;

import java.util.HashSet;
import java.util.Set;

public class SetDifference 
{
	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<>();
		set1.add(10);
		set1.add(22);
		set1.add(78);
		set1.add(20);
		set1.add(30);
		
		Set<Integer> set2 = new HashSet<>();
		set2.add(10);
		set2.add(25);
		set2.add(70);
		set2.add(20);
		set2.add(30);
		
		Set<Integer> diff = new HashSet<>(set1);
		diff.removeAll(set2);
		
		System.out.println(set1);
		System.out.println(set2);
		System.out.println("set1-set2: "+diff);
	}
}
