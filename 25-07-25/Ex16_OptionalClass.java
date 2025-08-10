package com.wipro.stream;

import java.util.Optional;

public class OptionalClass 
{
	public static void main(String[] args) {
		Optional<Integer> number = Optional.of(42);

		number.ifPresent(n -> System.out.println("Number is: " + n));

		Optional<Integer> emptyOptional = Optional.empty();

		Integer defaultNumber = emptyOptional.orElse(100);

		System.out.println("Default Value: " + defaultNumber);
	}
}
