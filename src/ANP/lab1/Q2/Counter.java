package ANP.lab1.Q2;

public class Counter extends Thread {
    private int count = 10;
    @Override
    public void run() {
        while (count <= 500) {
            if (Thread.currentThread().isInterrupted()){
                System.out.println("thread isInterrupted");
                break;
            }else {
                count++;
                System.out.println("Counter: ==>"+count);
            }
        }
    }
}