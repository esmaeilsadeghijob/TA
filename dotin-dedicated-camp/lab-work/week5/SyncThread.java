public class SyncThread {
    @Print
    int count = 0;
    int count2 = 0;

    public void increment() {
        synchronized (this) {
            count++;
        }
        count2 ++;
    }

    public void runThread() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increment();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increment();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try {

            t1.join();
            t2.join();
            //t3.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
        System.out.println(count2);
    }


    public static void main(String[] args) {
        SyncThread st = new SyncThread();
        st.runThread();
    }
}
