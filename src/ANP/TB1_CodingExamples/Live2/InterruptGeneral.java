package ANP.TB1_CodingExamples.Live2;

//https://www.tutorialspoint.com/javaexamples/thread_interrupt.htm
public class InterruptGeneral extends Object implements Runnable {
	public void run() {
		try {
			System.out.println("in run() - about to work2()");
			work2();
			System.out.println("in run() - back from work2()");
		} catch (InterruptedException x) {
			System.out.println("in run() - interrupted in work2()");
			return;
		}
		System.out.println("in run() - leaving normally");
	}

	public void work2() throws InterruptedException {
		System.out.println("in work2()");
		while (true) {
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("in work2() C isInterrupted()=" + Thread.currentThread().isInterrupted());
				Thread.sleep(2000);
				System.out.println("in work2() D isInterrupted()=" + Thread.currentThread().isInterrupted());
			}
		}
	}

	public void work() throws InterruptedException {
		while (true) {
			for (int i = 0; i < 100000; i++) {
				int j = i * 2;
			}
			System.out.println("in work() A isInterrupted()=" + Thread.currentThread().isInterrupted());
			if (Thread.interrupted()) {
				System.out.println("in work() B isInterrupted()=" + Thread.currentThread().isInterrupted());
				throw new InterruptedException();
			}
		}
	}

	public static void main(String[] args) {
		InterruptGeneral interruptGeneral = new InterruptGeneral();
		Thread thread = new Thread(interruptGeneral);
		thread.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException x) {
		}
		System.out.println("in main() - interrupting other thread");
		thread.interrupt();
		System.out.println("in main() - leaving");
	}
}
