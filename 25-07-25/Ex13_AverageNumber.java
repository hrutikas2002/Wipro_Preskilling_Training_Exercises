package com.wipro.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AverageNumber 
{
	public static void main(String[] args) 
	{

		List<Integer> nums = Arrays.asList(100, 200, 300, 400, 500, 600, 700);

		Double average = nums.stream()
				.collect(Collectors.averagingInt(x -> x));

		System.out.println("Average: " + average);
	}
}
