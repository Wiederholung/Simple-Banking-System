package com.metattri.anp.TB1_CodingExamples.Live3.volatiledemo;


public class VolatileDemoMain {

	public static void main(String[] args) 
	{
		// Create a new instance of VolatileDemo
		VolatileDemo runnable = new VolatileDemo();
		Thread thread = new Thread(runnable);
		
		thread.start(); //start the thread
		
		//Sleep for 3 seconds
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Ask the thread to stop
		runnable.pleaseStop();

	}

}
