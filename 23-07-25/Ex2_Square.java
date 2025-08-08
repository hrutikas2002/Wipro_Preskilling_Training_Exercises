package com.wipro.oop.test;

public class Square extends Shape{
	int side;

	public Square(String color, String position, int side) {
		super(color, position);
		this.side = side;
	}

	public Square() {
		super();
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	@Override
	public String toString() {
		return "Square [side=" + side + ", color=" + color + ", position=" + position + "]";
	}
	
	
}
