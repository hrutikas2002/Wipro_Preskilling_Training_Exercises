package com.wipro.functionalinterface;

//Using Consumer print the next even number. So if the input is 5 it will print 6 , if 100 is passed it will print 102.

import java.util.function.Consumer;

public class ConsumerNextEven 
{
	public static void main(String[] args) 
	{
		Consumer<Integer> nextEven = num -> 
		{
            int even = (num%2==0) ? num+2 : num+1;
            System.out.println("Next even number is: " + even);
        };
        
        nextEven.accept(5);
        nextEven.accept(100);
	}
}
