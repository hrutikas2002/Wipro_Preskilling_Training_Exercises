package com.wipro.oops;

import com.wipro.oop.test.Converter;

public class ConverterTest {
	public static void main(String[] args) {
		Converter c = new Converter();
		
		System.out.println(c.convert(10));
		System.out.println(c.covert(10, 20));
		System.out.println(c.convert(120));
	}
}
