package com.metattri.anp.TB1_CodingExamples.Live3.sync;


/**
 * This thread calls the manipulateAdd method on the shared Data Structure
 * @author gareth
 *
 */
public class AddingThread implements Runnable
{
	// A shared data structure
	public DataStructure structure = null;
	
	public AddingThread(DataStructure structure)
	{
		this.structure = structure;
	}
	
	
	public void run()
	{
		structure.manipulateAdd(1); //Adds to the data structure
	}
	
}
