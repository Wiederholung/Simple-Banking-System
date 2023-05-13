package com.metattri.anp.TB1_CodingExamples.Live1;

public class Order implements Runnable {
    public static void main(String[] args) {
        Order order = new Order();
        for (int i = 0; i < 25; i++) {
            Thread thread = new Thread(order);
            thread.setName("Thread " + i);
            thread.start();
        }
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("I'm running in thread-" + threadName);
    }
}
