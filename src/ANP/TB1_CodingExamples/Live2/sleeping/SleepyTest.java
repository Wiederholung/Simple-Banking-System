package ANP.TB1_CodingExamples.Live2.sleeping;

public class SleepyTest implements Runnable
{

	
	public void run()
	{
		System.out.println("Hello everybody! I'm going to sleep for 3 seconds...");
		try {
			Thread.sleep(3000); //Sleeps for 3 second
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("Bye bye everybody!");
	}
	
	/**
	 * Remember, the main method gets started in a new thread on its own
	 * Any new threads you create, will run in parallel to the main thread
	 * @param args
	 */
	public static void main(String args[])
	{
		// Creates a new thread that runs sleep
		SleepyTest testThread = new SleepyTest();
		Thread thread = new Thread(testThread);
		
		thread.start();
		
		
	}
}
