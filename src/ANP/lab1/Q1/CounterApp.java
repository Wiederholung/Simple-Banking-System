package ANP.lab1.Q1;

public class CounterApp {
    public static void main(String[] args) {
        // 先运行sleep的
        new Thread(new SleepyCounter()).start();
        // 再运行counter的
        Counter counter = new Counter();
        counter.start();

    }
}

