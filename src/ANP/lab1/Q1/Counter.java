package ANP.lab1.Q1;

public class Counter extends Thread {
    private int count = 10;
    @Override
    public void run() {
        while (count <= 500) {
            count++;
            System.out.println("Counter: ==>"+count);
        }
    }
}