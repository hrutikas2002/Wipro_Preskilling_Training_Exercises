package com.wipro.functionalinterface;

//Implement a lambda expression of this functional interface which prints “Hello Lambda”;
//Call the sayHello method of the lambda expression.

@FunctionalInterface
public interface Greet {
	void sayHello();
}
