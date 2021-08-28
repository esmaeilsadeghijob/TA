public class MyThread extends Thread {
    private Thread thread;
    private String threadName;
    int count;

    MyThread(String threadName) {
        this.threadName = threadName;
    }
    MyThread(int count) {
        System.out.println("new thread has been created!");
    }
    public void run() {
        System.out.println("thread " + threadName + " is running!");
        while (count > 0) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("error");
            }
            count--;
        }
        System.out.println("thread " + this.getName());
    }
    public void start() {
        System.out.println("starting thread " + threadName);
        if (thread == null) {
            thread = new Thread(this,threadName);
            thread.start();
        }
    }
}
