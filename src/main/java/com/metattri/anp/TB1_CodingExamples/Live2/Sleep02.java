package com.metattri.anp.TB1_CodingExamples.Live2;

//https://www.javatpoint.com/sleep()-method

class Sleep02 extends Thread {
    public static void main(String[] args) {
        Sleep02 t1 = new Sleep02();
        Sleep02 t2 = new Sleep02();

        t1.start();
        t2.start();
    }

    public void run() {
        for (int i = 1; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            // System.out.println(" " +i);
            // IMPORTANT if we print out the name of the thread we see the order
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
