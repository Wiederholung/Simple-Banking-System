package com.metattri.anp.TB1_CodingExamples.Live2.interrupts;

public class InterruptDuringSleepDemo implements Runnable {

    public static void main(String[] args) {
        InterruptDuringSleepDemo t = new InterruptDuringSleepDemo();
        Thread thread = new Thread(t);
        thread.start();

        //Note that you shouldn't usually ignore InterruptedExceptions like below
        //But we're doing it just as a demo
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        //After waiting for 2 seconds, this Main Thread calls interrupt on the InterruptExampleThread
        thread.interrupt();

    }

    public void run() {
        System.out.println("I'm starting the thread");

        while (!Thread.currentThread().isInterrupted()) {
            // Do stuff, e.g. processing data
            try {
                Thread.sleep(1000); //Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println("I've been interrupted!");
                Thread.currentThread().interrupt(); //We have to launch this interrupt again
                //Because Thread.sleep will have already
                //set it back to false using interrupted()
            }
        }

        System.out.println("I'm ending the thread");
    }
}
