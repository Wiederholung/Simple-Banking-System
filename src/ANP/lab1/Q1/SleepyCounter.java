package ANP.lab1.Q1;

public class SleepyCounter implements Runnable {
    @Override
    public void run() {
        int count = 10;
        while (count <= 50) {
            count++;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("SleepyCounter: ==>"+count);
        }
    }
}
