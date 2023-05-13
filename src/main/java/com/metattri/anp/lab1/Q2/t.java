package com.metattri.anp.lab1.Q2;

/**
 * Thread.sleep() 方法会抛出一个 InterruptedException 异常，当线程被 sleep() 休眠时，如果被中断，这会就抛出这个异常。
 *         （注意：Thread.sleep() 方法由于中断而抛出的异常，是会清除中断标记的。）
 */

public class t {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("thread start");
            try {
                System.out.println("thread sleep 1s");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("thread InterruptedException");
            }
            for (int i=0;i<3000;i++){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("thread isInterrupted");
                    break;
                }else {
                    System.out.println(i);
                }
            }
            System.out.println("thread end");
        });
        thread.start();
        try {
            System.out.println("main start to sleep 10ms");
            Thread.sleep(10);
            System.out.println("main sleep 10ms end");
        } catch (InterruptedException e) {
            System.out.println("InterruptedException:"+e);
        }
        System.out.println("thread interrupt");
//        thread.stop();
        thread.interrupt();
        System.out.println("thread interrupt...");
        try {
            System.out.println("main star to sleep 2s");
            Thread.sleep(2000);
            System.out.println("main sleep 2s end");
        } catch (InterruptedException e) {
            System.out.println("InterruptedException:"+e);
        }
        System.out.println("main end");
    }

}
