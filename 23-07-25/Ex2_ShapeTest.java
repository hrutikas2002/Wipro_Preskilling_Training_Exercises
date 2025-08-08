package com.wipro.oops;

import com.wipro.oop.test.Circle;
import com.wipro.oop.test.Rectangle;
import com.wipro.oop.test.Square;

public class ShapeTest {
	public static void main(String[] args) {
		
		Circle c = new Circle("blue","right-top",7);
		System.out.println(c);
		
		Rectangle r = new Rectangle("Red","Bottom",10,20);
		System.out.println(r);
		
		Square s = new Square("Yellow","Middle",25);
		System.out.println(s);
	}
}
