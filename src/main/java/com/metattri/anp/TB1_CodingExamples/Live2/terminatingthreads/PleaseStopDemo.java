package com.metattri.anp.TB1_CodingExamples.Live2.terminatingthreads;

public class PleaseStopDemo implements Runnable {
    //When this is set to true, the thread should finish
    private volatile boolean pleaseFinish = false;

    public static void main(String[] args) {
        PleaseStopDemo t = new PleaseStopDemo();
        Thread thread = new Thread(t);
        thread.start();

        // Sleeps for 4 seconds
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Asks thread to finish
        t.askToFinish();

    }

    public void run() {
        System.out.println("I'm starting the thread");

        //Loops until pleaseFinish is set to true
        while (!pleaseFinish) {
            System.out.println("I'm still running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }

        System.out.println("I'm ending the thread");
    }

    public void askToFinish() {
        pleaseFinish = true;
    }
}