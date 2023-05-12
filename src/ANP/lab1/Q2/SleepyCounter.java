package ANP.lab1.Q2;

public class SleepyCounter implements Runnable {
    public int sleepCount = 10;
    @Override
    public void run() {

        while (sleepCount <= 500) {
            if (Thread.currentThread().isInterrupted()){
                System.out.println("thread isInterrupted");
                break;
            }
            else {
                sleepCount++;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("SleepyCounter: ==>"+sleepCount);
            }
        }
    }
}
