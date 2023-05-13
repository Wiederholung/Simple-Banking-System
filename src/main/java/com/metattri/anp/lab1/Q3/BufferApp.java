package com.metattri.anp.lab1.Q3;

public class BufferApp {
    public static void main(String[] args) {
        Buffer buf = new Buffer(50);
        Producer producer = new Producer(buf);
        Consumer consumer = new Consumer(buf);
        Thread th1 = new Thread(producer);
        Thread th2 = new Thread(consumer);
        th1.start();
        th2.start();
//        try {
//            th1.join();
//            th2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(buf.isFull());
        System.out.println(buf.isEmpty());
    }
}


/**
 * e)
 * -
 * 1）wait():当某个线程获取到锁后，发现当前还不满足执行的条件，就可以调用对象锁的wait方法，进入Waiting状态。
 * 2）notify():当某个线程获取到锁后，发现当前满足执行的条件，就可以调用对象锁的notify方法，唤醒一个Waiting状态的线程。
 * -
 * 1）当全部方法都需要线程同步安全时，可以使用synchronized关键字修饰方法。
 * 2）使用synchronized关键字修饰方法时，程序中只能有一个线程可以执行该方法，导致程序效率低下。
 * - 死锁问题
 * 解决：1）避免一个线程同时获取多个锁。
 * 2）避免一个线程在锁内占用多个资源，尽量保证每个锁只占用一个资源。
 * 3）尝试使用定时锁，使用lock.tryLock(timeout)来替代使用内部锁机制。
 * 4）对于数据库锁，加锁和解锁必须在一个数据库连接里，否则会出现解锁失败的情况。
 * 5）加锁顺序。加锁时，按照对象的hashcode顺序加锁。
 * 6）避免锁的嵌套。如果有多个锁，不要一个锁内调用另一个锁，可能会造成死锁。
 * 7）只在必要的地方加锁。不是所有的代码都需要同步，只有多个线程访问同一个资源，才需要同步。
 */