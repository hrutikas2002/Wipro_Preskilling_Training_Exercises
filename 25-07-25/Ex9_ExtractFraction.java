package com.wipro.functionalinterface;

import java.util.function.Function;

public class ExtractFraction 
{
	public static void main(String[] args) 
	{
		Function<Double,Double> fraction = num ->num - Math.floor(num);

        double num = 123.4589;

        double result = fraction.apply(num);

        System.out.println("Fractional part:" +result); 
	}
}
