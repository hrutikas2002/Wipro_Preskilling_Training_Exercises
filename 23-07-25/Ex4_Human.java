package com.wipro.oop.test;

public class Human extends Animal{


	public Human(String animalName, String shelter) {
		super(animalName, shelter);
	}

	@Override
	public void eat() {
		System.out.println(animalName+" eating inside "+shelter);
	}

	@Override
	public void makeSound() {
		System.out.println("Human speaks");
	}

}
