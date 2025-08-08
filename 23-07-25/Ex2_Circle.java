package com.wipro.oop.test;

public class Circle extends Shape{
	int radius;

	public Circle() {
		super();
	}

	public Circle(String color, String position, int radius) {
		super(color, position);
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", color=" + color + ", position=" + position + "]";
	}

		
}
