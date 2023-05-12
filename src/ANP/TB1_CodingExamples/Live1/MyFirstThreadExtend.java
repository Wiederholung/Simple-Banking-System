package ANP.TB1_CodingExamples.Live1;

/**
 * This class extends Thread. It therefore inherits all the functionality of the
 * Thread class. This allows MyThread to execute methods like start()
 */
public class MyFirstThreadExtend extends Thread {

	public void run() {
		System.out.println("Entering thread using MyThread extends Thread");
		System.out.println("do some interesting stuff");
		System.out.println("Leaving thread using MyThread extends Thread");
	}

	// We'll now create a thread 
	public static void main(String[] args) {
		// This approach uses a class the extends Thread
		MyFirstThreadExtend myFirstThreadExtend = new MyFirstThreadExtend();
		myFirstThreadExtend.start();
	}
}