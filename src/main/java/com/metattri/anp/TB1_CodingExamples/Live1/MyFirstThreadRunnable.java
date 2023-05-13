package com.metattri.anp.TB1_CodingExamples.Live1;

/**
 * This class implements Runnable. As such, it "promises" the Java compiler that
 * it will contain a run() method. Try renaming the run() method to ran(). See
 * what happens...an error will occur because you will have broken your
 * "promise" to implement run()
 */
public class MyFirstThreadRunnable implements Runnable {

	public void run() {
		System.out.println("Entering thread using MyRunnable implements Runnable");
		System.out.println("do some interesting stuff");
		System.out.println("Leaving thread using MyRunnable implements Runnable");
	}

	public static void main(String[] args) {
		// This approach uses a class that implements the Runnable interface
		// this is the recommended way.
		MyFirstThreadRunnable myFirstThreadRunnable = new MyFirstThreadRunnable();
		Thread thread = new Thread(myFirstThreadRunnable);
		thread.start();
		

	}

}
