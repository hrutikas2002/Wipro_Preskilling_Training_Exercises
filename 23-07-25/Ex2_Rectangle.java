package com.wipro.oop.test;

public class Rectangle extends Shape{

	int length;
	int bredth;
	
	public Rectangle(String color, String position, int length, int bredth) {
		super(color, position);
		this.length = length;
		this.bredth = bredth;
	}
	
	public Rectangle() {
		super();
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getBredth() {
		return bredth;
	}

	public void setBredth(int bredth) {
		this.bredth = bredth;
	}

	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", bredth=" + bredth + ", color=" + color + ", position=" + position
				+ "]";
	}

	
}
