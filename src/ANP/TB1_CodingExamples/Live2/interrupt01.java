package ANP.TB1_CodingExamples.Live2;

public class interrupt01 extends Thread {
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("Finished!");
		} catch (InterruptedException e) {
			System.out.println("I'm interrupted!");
			System.exit(-1);
		}
	}

	public static void main(String args[]) {
		interrupt01 t1 = new interrupt01();
		t1.start();
		try {
			t1.interrupt();
		} catch (Exception e) {
			System.out.println("Exception handled " + e);
		}
	}
}
