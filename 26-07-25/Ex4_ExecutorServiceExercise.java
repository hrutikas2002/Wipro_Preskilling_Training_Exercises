package com.wipro.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExercise {
    public static void main(String[] args) {
    	
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 5; i++) 
        {
            int task = i;
            
            executor.submit(() -> {
                try {
                    for (int j=1; j<=10; j++) {
                        System.out.println("Task " + task + " printed: "+ j);
                        Thread.sleep(1000); 
                    }
                } catch (Exception e) {
                	e.printStackTrace();
                }
            });
        }
    }
}