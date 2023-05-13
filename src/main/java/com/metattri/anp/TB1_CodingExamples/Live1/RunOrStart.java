package com.metattri.anp.TB1_CodingExamples.Live1;

/**
 * This class implements Runnable. As such, it "promises" the Java compiler that
 * it will contain a run() method. Try renaming the run() method to ran(). See
 * what happens...an error will occur because you will have broken your
 * "promise" to implement run()
 */
public class RunOrStart implements Runnable {

	public void run() {
		System.out.println("this is the run method");
	}
	
	public void start() {
		System.out.println("this is the start method");
	}

	public static void main(String[] args) {
		RunOrStart myFirstThreadRunnable = new RunOrStart();
		Thread thread = new Thread(myFirstThreadRunnable);
		thread.start();
//		thread.run();
		
	}
}
