package com.wipro.test;

import com.wipro.anonymousclass.BankOps;

public class BankOpsTest {
	public static void main(String[] args) {
		
		BankOps savingAccount = new BankOps() {
			@Override
			public void deposit(double amount) {
				System.out.println(amount+" amount deposited.");
			}
		};
		
		BankOps currentAccount = new BankOps() {
			@Override
			public void deposit(double amount) {
				System.out.println(amount+" amount deposited.");
			}
		};
		
		savingAccount.deposit(5000);
		currentAccount.deposit(789456);
	}
}
