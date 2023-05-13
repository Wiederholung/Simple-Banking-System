package com.metattri.anp.TB1_CodingExamples.Live1.creatingthreads;

/**
 * This class extends Thread. It therefore inherits all the functionality of the Thread class.
 * This allows MyThread to execute methods like start()
 *
 * @author gareth
 */
public class MyThread extends Thread {


    public void run() {
        System.out.println("Entering thread");

        System.out.println("Leaving thread");
    }


}