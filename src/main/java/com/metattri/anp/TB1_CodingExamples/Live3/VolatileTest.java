package com.metattri.anp.TB1_CodingExamples.Live3;

//https://dzone.com/articles/java-volatile-keyword-0
public class VolatileTest {

    private static volatile int x = 0;

    public static void main(String[] args) {
        new ChangeListener().start();
        new ChangeMaker().start();
    }

    static class ChangeListener extends Thread {
        public void run() {
            int local_value = x;
            while ( local_value < 5){
                if( local_value!= x){
                    System.out.println("Got Change for x "+ x);
                     local_value= x;
                }
            }
        }
    }

    static class ChangeMaker extends Thread{
        public void run() {
            int local_value = x;
            while (x <5){
                System.out.println("Incrementing x to "+ (local_value+1));
                x = ++local_value;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }
}
