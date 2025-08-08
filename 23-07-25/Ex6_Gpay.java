package com.wipro.oop.test;

public class Gpay implements PaymentMethod
{
	public void pay(double amount) {
		System.out.println(amount+ " paid via Gpay");
	}

}
