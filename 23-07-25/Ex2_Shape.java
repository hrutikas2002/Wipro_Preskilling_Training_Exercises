package com.wipro.oop.test;

public class Shape {
	String color;
	String position;
	public Shape(String color, String position) {
		super();
		this.color = color;
		this.position = position;
	}
	public Shape() {
		super();
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		return "Shape [color=" + color + ", position=" + position + "]";
	}
	
	
}
