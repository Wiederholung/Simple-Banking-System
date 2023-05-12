package ANP.TB1_CodingExamples.Live3;

//https://www.javatpoint.com/synchronization-in-java
class MultiplicationTable {
	//void printTable(int n) {// method not synchronized
	synchronized void printTable(int n) {// method not synchronized
		
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + "\t*\t" + n +"\t=\t"+ n* i);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}

class MyThread1 extends Thread {
	MultiplicationTable t;
	MyThread1(MultiplicationTable t) {
		this.t = t;
	}
	public void run() {
		t.printTable(5);
	}
}

class MyThread2 extends Thread {
	MultiplicationTable t;
	MyThread2(MultiplicationTable t) {
		this.t = t;
	}
	public void run() {
		t.printTable(100);
	}
}

class Synchronization1 {
	public static void main(String args[]) {
		MultiplicationTable obj = new MultiplicationTable();// only one object
		MyThread1 t1 = new MyThread1(obj);
		MyThread2 t2 = new MyThread2(obj);
		t1.start();
		t2.start();
	}
}