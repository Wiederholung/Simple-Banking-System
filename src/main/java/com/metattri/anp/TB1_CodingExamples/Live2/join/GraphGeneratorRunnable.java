package com.metattri.anp.TB1_CodingExamples.Live2.join;

/**
 * This is an example class which 'pretends' to generate graphs (e.g. bar charts)
 * from a given set of data.
 * @author Gareth
 *
 */
public class GraphGeneratorRunnable implements Runnable
{
	private Thread thread = null;
	
	/**
	 * This constructor accepts an instance of a Thread. This is a copy of the ReadRunnable class.
	 * The reasons we do this, is that this thread must wait before ReadRunnable has completed.
	 * Therefore we need a reference to the ReadRunnable object, so that we can call the join()
	 * operation
	 * @param thread The thread that we will wait to finish before executing
	 */
	public GraphGeneratorRunnable(Thread thread)
	{
		this.thread = thread;
	}
	
	public void run()
	{
		//IDEA: Try removing thread.join and see what happens...
		
		try {
			thread.join(); // join() will "pause" the execution of the code until "thread" has completed
							// In this case "thread" is a reference to the ReadRunnable thread we created
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// We only start to generate graphs *after* ReadRunnable has terminated
		System.out.println("Starting to generate graphs...");
	}
}
