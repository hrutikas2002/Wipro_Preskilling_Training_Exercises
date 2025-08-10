package com.wipro.thread;

public class CounterTest 
{
	public static void main(String[] args) 
	{
		
		Counter c = new Counter();

        CounterThread thread1 = new CounterThread(c);
        CounterThread thread2 = new CounterThread(c);

        thread1.start();
        thread2.start();

        try {
            thread1.join(); 
            thread2.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Count: "+c.getCount());
	}
}
