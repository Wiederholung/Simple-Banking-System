package com.metattri.anp.TB1_CodingExamples.Live3.monitors;

public class WaitDemoMain
{
	
	
	public static void main(String[] args)
	{
		
		WhyWait ww = new WhyWait();
		ww.start();
		
		
		
		// Gets locks for ww before continuing
		synchronized(ww)
		{
			try {
				ww.wait(100);  //waits for notify signal from ww. We wait for a maximum of 100 ms
			} 
			catch (InterruptedException e)
			{} //this catch should really do something useful (but for a simple demo, we leave it blank)
			
		}
		
		System.out.println("Sum = " + WhyWait.sum);
	}
	
	
}