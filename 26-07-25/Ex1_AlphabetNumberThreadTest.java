package com.wipro.test;

import com.wipro.thread.AlphabetThread;
import com.wipro.thread.NumberThread;

public class AlphabetNumberThreadTest {
	public static void main(String[] args) 
	{
		NumberThread numThread = new NumberThread();
		AlphabetThread alphaThread = new AlphabetThread();

		numThread.start();
		alphaThread.start();
	}
}
