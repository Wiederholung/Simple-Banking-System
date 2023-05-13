package com.metattri.anp.TB1_CodingExamples.Live2;

//https://beginnersbook.com/2015/03/thread-join-method-in-java-with-example/
public class JoinExample0 {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new MyClass(), "thread1");
		Thread thread2 = new Thread(new MyClass(), "thread2");
		Thread thread3 = new Thread(new MyClass(), "thread3");

		thread1.start();// Start first thread immediately

		// Start second thread(th2) once first thread(th1) is dead
		try {
			thread1.join();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		thread2.start();

		/*
		 * Start third thread(th3) once second thread(th2) is dead
		 */
		try {
			thread2.join();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		thread3.start();

		// Displaying a message once third thread is dead
		try {
			thread3.join();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		System.out.println("All three threads have finished execution");
	}
}

class MyClass implements Runnable {

	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("Thread started: " + t.getName());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		System.out.println("Thread ended: " + t.getName());
	}
}