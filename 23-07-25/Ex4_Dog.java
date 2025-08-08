package com.wipro.oop.test;

public class Dog extends Animal
{

	public Dog(String animalName, String shelter) {
		super(animalName, shelter);
	}

	@Override
	public void eat() {
		System.out.println(animalName+" eating inside "+shelter);
	}

	@Override
	public void makeSound() {
		System.out.println("Dog barks");
	}
	
}
