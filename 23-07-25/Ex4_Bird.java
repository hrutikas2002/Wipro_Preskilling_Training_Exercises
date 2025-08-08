package com.wipro.oop.test;

public class Bird extends Animal
{

	public Bird(String animalName, String shelter) {
		super(animalName, shelter);
	}

	@Override
	public void eat() {
		System.out.println(animalName+" eating inside "+shelter);
	}

	@Override
	public void makeSound() {
		System.out.println("Birds sounding tweet tweet");
	}
	
}
