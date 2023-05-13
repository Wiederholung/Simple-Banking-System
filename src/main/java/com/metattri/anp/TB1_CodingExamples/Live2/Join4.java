package com.metattri.anp.TB1_CodingExamples.Live2;

//https://www.javatpoint.com/join()-method
class Join4 extends Thread {
    public static void main(String[] args) {
        Join4 t0 = new Join4();
        Join4 t1 = new Join4();
        Join4 t2 = new Join4();
        t0.start();
        try {
            t0.join();
        } catch (Exception e) {
            System.out.println(e);
        }

        // these thread join after t0 has finished
        t1.start();
        t2.start();
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
