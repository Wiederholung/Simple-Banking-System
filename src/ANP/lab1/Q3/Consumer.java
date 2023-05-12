package ANP.lab1.Q3;

class Consumer implements Runnable {
    private Buffer buffer;
    public Consumer(Buffer b) { buffer = b; }
    public void run() {
        for (int i=0; i<50; i++) {
            System.out.println(buffer.get());
        }
    }
}
