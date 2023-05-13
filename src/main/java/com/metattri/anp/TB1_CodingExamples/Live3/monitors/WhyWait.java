package com.metattri.anp.TB1_CodingExamples.Live3.monitors;

public class WhyWait extends Thread
{
	public static volatile int sum = 0;
	
	public void run()
	{
			
		synchronized(this) //use its own lock
		{
			for(int i=0; i<10; i++)
			{
				sum = sum + i; //manipulates the sum variable
			}
			
			notify(); //notify any threads waiting on this monitor to wake up
		}
		
		
	}
	
	
	
}
