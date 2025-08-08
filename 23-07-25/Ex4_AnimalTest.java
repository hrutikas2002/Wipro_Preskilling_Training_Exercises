package com.wipro.oops;

import com.wipro.oop.test.Bird;
import com.wipro.oop.test.Dog;
import com.wipro.oop.test.Human;

public class AnimalTest {
	public static void main(String[] args) {
		Human h = new Human("ABC","Home");
		Bird b = new Bird("Parrot","Cage");
		Dog d = new Dog("Tommy","Kennel");
		
		h.eat();
		h.makeSound();
		
		b.eat();
		b.makeSound();
		
		d.eat();
		d.makeSound();
	}
}
