package com.wipro.test;

import java.util.Scanner;

import com.wipro.solid.DigitalPayment;
import com.wipro.solid.GooglePay;
import com.wipro.solid.Paytm;
import com.wipro.solid.PhonePay;


public class DigitalPaymentTest {
	public static void main(String[] args) {
		DigitalPayment dp ;
		
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter choice: ");
		choice = sc.nextInt();
		
		if(choice==1) {
			dp = new PhonePay();
			dp.pay(10000);
		}
		else if(choice==2) {
			dp = new GooglePay();
			dp.pay(choice);
		}
		else if(choice==3) {
			dp = new Paytm();
			dp.pay(6000);
		}
	}
}
