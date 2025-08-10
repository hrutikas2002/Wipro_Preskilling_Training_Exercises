package com.wipro.thread;

public class Counter {
	int count = 0;
	
	synchronized void increment() {
		count++;
	}
	
	int getCount() {
		return count;
	}
}
