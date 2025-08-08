package com.wipro.oop.test;

public abstract class Animal {
	String animalName;
	String shelter;
	public Animal(String animalName, String shelter) {
		super();
		this.animalName = animalName;
		this.shelter = shelter;
	}
	
	public abstract void eat();
	public abstract void makeSound();
}
