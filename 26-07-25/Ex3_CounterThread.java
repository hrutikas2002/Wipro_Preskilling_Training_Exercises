package com.wipro.thread;

public class CounterThread extends Thread 
{
    private Counter counter;

    public CounterThread(Counter counter) 
    {
        this.counter = counter;
    }

    @Override
    public void run() 
    {
        try {
            for (int i = 0; i < 10; i++) {
                counter.increment();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
