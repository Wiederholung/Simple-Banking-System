package ANP.TB1_CodingExamples.Live3;

//https://www.javatpoint.com/synchronized-block-example
class Table {

	void printTable(int n) {
//		synchronized (this) {// synchronized block
			 {
			for (int i = 1; i <= 5; i++) {
				System.out.println(n * i);
				try {
					Thread.sleep(400);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}// end of the method
}

class MyThread1a extends Thread {
	Table t;

	MyThread1a(Table t) {
		this.t = t;
	}

	public void run() {
		t.printTable(5);
	}

}

class MyThread2a extends Thread {
	Table t;

	MyThread2a(Table t) {
		this.t = t;
	}

	public void run() {
		t.printTable(100);
	}
}

public class SynchronizedBlock1 {
	public static void main(String args[]) {
		Table obj = new Table();// only one object
		MyThread1a t1 = new MyThread1a(obj);
		MyThread2a t2 = new MyThread2a(obj);
		//no guarantee of which one will run first. 
		t1.start();
		t2.start();
	}
}
