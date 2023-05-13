package com.metattri.anp.TB1_CodingExamples.Live1.creatingthreads;

public class MainTest {

	public static void main(String[] args) 
		{

		//We'll now create threads using the two approaches
		
		
		// The first approach uses a class that implements the Runnable interface
		MyRunnable runnable = new MyRunnable();
		Thread thread = new Thread(runnable);
		thread.start();
		
		// The second approach uses a class the extends Thread
		MyThread myThread = new MyThread();
		myThread.start();
		
		}

}
