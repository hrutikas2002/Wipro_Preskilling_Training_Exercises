package com.wipro.oops;

import com.wipro.oop.test.Gpay;
import com.wipro.oop.test.PaymentMethod;
import com.wipro.oop.test.PhonePay;

public class PaymentMethodTest 
{
	public static void main(String[] args) {
		PaymentMethod p1;
		
		p1 = new Gpay();
		p1.pay(1000);
		
		p1 = new PhonePay();
		p1.pay(45000);
		
	}
}
