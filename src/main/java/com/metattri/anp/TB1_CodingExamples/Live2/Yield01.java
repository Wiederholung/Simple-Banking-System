package com.metattri.anp.TB1_CodingExamples.Live2;

//https://www.tutorialspoint.com/java/lang/thread_yield.htm
public class Yield01 implements Runnable {
    Thread t;

    Yield01(String str) {
        t = new Thread(this, str);
        t.start();// this will call run() function
    }

    public static void main(String[] args) {
        new Yield01("Thread 1");
        new Yield01("Thread 2");
        new Yield01("Thread 3");
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            // yields control to another thread every 5 iterations
            if ((i % 5) == 0) {
                System.out.println(Thread.currentThread().getName() + " yielding control...");
            /* causes the currently executing thread object to temporarily
            pause and allow other threads to execute */
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread().getName() + " has finished executing.");
    }
}
