package com.metattri.anp.TB1_CodingExamples.Live3.sync;


/**
 * This thread shows an example of using synchronized. 
 * It creates 10 threads that add to a shared data structure and 10 threads that minus from it
 * This is just a demo that prints out messages to show how only one thread can execute the
 * manipulateAdd() and manipulateMinus() methods at one time
 * @author gareth
 *
 */
public class MainTest {

	public static void main(String[] args) 
	{
		//Create a shared data structure
		DataStructure sharedDataStruct = new DataStructure();
		
		// Loops 10 times and creates threads
		for(int i=0; i<10; i++)
		{
			// Creates 10 thread that add 1 to the shared data structure
			AddingThread myRunnable = new AddingThread(sharedDataStruct);
			Thread thread = new Thread(myRunnable);
			
			// Creates 10 threads that minus 1 from the shared data structure
			MinusThread myRunnable2 = new MinusThread(sharedDataStruct);
			Thread thread2 = new Thread(myRunnable2);
		
			//Executes each thread
			thread.start();
			thread2.start();
		}
		
	}

}
