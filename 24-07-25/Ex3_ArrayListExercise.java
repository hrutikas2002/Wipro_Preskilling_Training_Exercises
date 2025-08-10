package com.wipro.collection;

import java.util.ArrayList;

public class ArrayListExercise {
	public static void main(String[] args) {
		ArrayList <Integer> list = new ArrayList<>();
		list.add(12);
		list.add(40);
		list.add(70);
		list.add(90);
		list.add(100);
		System.out.println("List: ");
		for(int i:list) {
			System.out.println(i);
		}

		list.remove(2);
		System.out.println("List after removing element from index 2: ");
		for(int i:list) {
			System.out.println(i);
		}

		list.add(200);

		System.out.println("List After adding element at end: ");
		for(int i:list) {
			System.out.println(i);
		}
	}
}
