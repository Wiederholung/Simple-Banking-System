package ANP.TB1_CodingExamples.Live3;

public class VolatileDemo implements Runnable {
	// Try removing volatile and see what happens...
	private volatile boolean pleaseStop = false;

	public void run() {
		System.out.println("Entering Thread");
		// This while loop will continue to loop until pleaseStop has been set to true
		while (pleaseStop == false) {
			// Do something
		}
		System.out.println("Leaving Thread...");
	}

	// Other threads can call pleaseStop to ask that this thread stops running
	public void pleaseStop() {
		pleaseStop = true;
	}
	
	public static void main(String[] args) 
	{
		// Create a new instance of VolatileDemo
		VolatileDemo runnable = new VolatileDemo();
		Thread thread = new Thread(runnable);
		
		thread.start(); //start the thread
		try {
			Thread.sleep(3000);//Sleep for 3 seconds
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		runnable.pleaseStop();// Ask the thread to stop
	}
}
