package com.metattri.anp.TB1_CodingExamples.Live2.interrupts;

/**
 * This demo shows how to check for an interrupt signal in your code
 *
 * @author gareth
 */
public class InterruptedCheckDemo extends Thread {


    public static void main(String[] args) {
        InterruptedCheckDemo thread = new InterruptedCheckDemo();
        thread.start();

        //Waits for 1 second
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Sends interrupt signal to thread
        thread.interrupt();
    }

    /**
     * This thread just loops around doing nothing. However, if another thread
     * interrupts it, it will terminate its loop and exit the thread
     */
    public void run() {
        System.out.println("Starting to run thread");
        while (!interrupted()) {
            // Just loops around doing nothing
            // Here you would put your actual code (e.g data processing)

        }
        System.out.println("Thread Finished");
    }
}
