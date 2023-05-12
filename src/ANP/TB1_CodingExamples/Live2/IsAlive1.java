package ANP.TB1_CodingExamples.Live2;

//https://way2java.com/multithreading/java-made-simple-what-is-isalive-in-java-with-example/
public class IsAlive1 extends Thread {
	public void run() {
		Thread t1 = Thread.currentThread();
		System.out.println("1 From run method, status of t1 = " + t1.isAlive());
	}

	public static void main(String args[]) {
		IsAlive1 myThread = new IsAlive1();
		System.out.println("2 From main method, status = " + myThread.isAlive());
		myThread.start();
		System.out.println("3 From main method, status = " + myThread.isAlive());
		try {
			System.out.println("4 From main method, status = " + myThread.isAlive());
			myThread.join();
			System.out.println("5 From main method, status = " + myThread.isAlive());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("6 From main method, status = " + myThread.isAlive());
	}
}