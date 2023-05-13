package com.metattri.anp.TB1_CodingExamples.Live3.sync;


/**
 * This class pretends to be a complex data structure that gets manipulated by multiple threads.
 * In reality, the methods just print out messages.
 * IDEA: Try removing the "synchronized" keywords to see what happens.
 * @author gareth
 *
 */
public class DataStructure {

	
	/**
	 * The shared data that needs to be protected
	 */
	private volatile int data = 0;
	/**
	 * This lock1 is not used because the methods below synchronized on (this).
	 * Try replacing synchronized(this) with synchronized(lock1). What does this allow?
	 */
	private Object lock1 = new Object();
	
	
	/**
	 * This method pretends to "add" the data
	 * It is synchronized method, which means only 1 thread can execute the code at any given time
	 */
	public synchronized void manipulateAdd(int number )
	{
			System.out.println("Starting to add data");
			data = data + number;
			System.out.println("Finishing adding data");
		
	}
	
	/**
	 * This method pretend to "minus" the data
	 * We do not say "synchronized" in the method declaration, but we do have a synchronized
	 * block inside the method
	 */
	public void manipulateMinus(int number)
	{
			// The synchronized(this) block is the same as putting synchronized in the method declaration
			// This is because the synchronized block surround *all* lines of code in the method
			synchronized(this) //IDEA: Try replacing (this) with (lock1) to see what happens
			{
				System.out.println("Starting to minus data");
				data = data - number;
				System.out.println("Finishing to minus data");
			}
		
	}
	
	public int getData()
	{
		return data;
	}
	
	/**
	 * This method does not manipulate data, so we do not set it as synchronized
	 */
	public void printStatus()
	{
		System.out.println("My status is okay!");
	}
	
}
