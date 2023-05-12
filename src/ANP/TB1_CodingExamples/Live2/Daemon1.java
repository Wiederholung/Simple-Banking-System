package ANP.TB1_CodingExamples.Live2;

//https://www.javatpoint.com/daemon-thread

public class Daemon1 extends Thread {
	public void run() {
		System.out.println("currentThread is "+Thread.currentThread().getName());
		if (Thread.currentThread().isDaemon()) {// checking for daemon thread
			System.out.println("daemon thread ");
		} else {
			System.out.println("user thread ");
		}
	}

	public static void main(String[] args) {
		Daemon1 t1 = new Daemon1();
		Daemon1 t2 = new Daemon1();
		Daemon1 t3 = new Daemon1();

		t1.setDaemon(true);// now t1 is daemon thread

		t1.start();// starting threads
		t2.start();
		t3.start();
	}
}
