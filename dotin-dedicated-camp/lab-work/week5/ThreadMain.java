public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <10 ; i++) {
            MyThread t = new MyThread("thread " + i);
            t.start();
            if (i == 2) {
                t.join();
                t.isAlive();
                t.getId();
            }

        }

    }
}
