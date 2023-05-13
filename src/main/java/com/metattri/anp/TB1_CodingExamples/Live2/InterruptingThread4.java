package com.metattri.anp.TB1_CodingExamples.Live2;

//https://www.javatpoint.com/interrupting-a-thread
public class InterruptingThread4 extends Thread {
    public static void main(String[] args) {
        InterruptingThread4 t1 = new InterruptingThread4();
        InterruptingThread4 t2 = new InterruptingThread4();
        t1.start();
        t1.interrupt();
        //t2.start();
    }

    public void run() {
        for (int i = 1; i <= 2; i++) {
            System.out.println("i = " + i + " for thread " + Thread.currentThread().getName());
            if (Thread.interrupted()) {
                System.out.println("code for interrupted thread " + Thread.currentThread().getName());
            } else {
                System.out.println("code for normal thread " + Thread.currentThread().getName());
            }
        } // end of for loop
    }
}