package com.wipro.test;

import com.wipro.generics.Box;

public class BoxTest 
{
	public static void main(String[] args) 
	{
		 Box<Integer> b1 = new Box(234);
		 b1.setT(123);
		 System.out.println(b1.getT());
		 
		 
		 Box<String> b2 = new Box("ABC");
		 b2.setT("Rutika");
		 System.out.println(b2.getT());
	}
}
