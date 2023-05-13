package com.metattri.anp.lab1.Q2;

public class CounterApp {
    public static void pleaseFinish(Thread thread) {
        thread.interrupt();
    }


    public static void main(String[] args) {
        SleepyCounter sleepyCounter2 = new SleepyCounter();

        Thread sleepThread = new Thread(sleepyCounter2);
        sleepThread.start();

        pleaseFinish(sleepThread);

        // 再运行counter的
        Counter counter = new Counter();
        counter.start();

        // 使用join确保Finish在最后
        try {
            sleepThread.join();
            counter.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished");
    }
}


/**
 * d)
 * - Thread.sleep() 方法会抛出一个 InterruptedException 异常，当线程被 sleep() 休眠时，如果被中断，这会就抛出这个异常。 注意：Thread.sleep() 方法由于中断而抛出的异常，是会清除中断标记的。）
 * - join()：合并线程，待此线程执行完后再执行其他线程  wait():表示线程等待,直到其他线程通知,与sleep不同的是会释放锁
 * - 1）在 run() 方法执行完毕后，该线程就终止了。
 *   2）使用 stop() 终止线程（不推荐使用）
 */
