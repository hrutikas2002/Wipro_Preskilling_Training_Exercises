package com.wipro.oop.test;

public class PhonePay implements PaymentMethod
{
	public void pay(double amount) {
		System.out.println(amount+" paid via PhonePay");
	}

}
