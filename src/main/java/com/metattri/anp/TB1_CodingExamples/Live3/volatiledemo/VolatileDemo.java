package com.metattri.anp.TB1_CodingExamples.Live3.volatiledemo;


public class VolatileDemo implements Runnable
{

	// Try removing volatile and see what happens...
	private boolean pleaseStop = false;
	
	public void run()
	{
		System.out.println("Entering Thread");
		
		// This while loop will continue to loop until pleaseStop has been set to true
		while(pleaseStop == false)
		{
			//Do something
		}
		
		System.out.println("Leaving Thread...");
	}
	
	/** Other threads can call pleaseStop to ask that this
	 * thread stops running
	 */
	public void pleaseStop()
	{
		pleaseStop = true;
	}
	
}
