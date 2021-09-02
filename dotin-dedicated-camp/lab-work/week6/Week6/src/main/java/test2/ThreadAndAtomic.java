package test2;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadAndAtomic {

//    volatile int count = 0;
//
//    public void increment() {
//        count++;
//    }
    private final AtomicInteger count = new AtomicInteger(0);

    public int getValue() {
        return count.get();
    }

    public void increment() {
        while (true) {
            int existValue = getValue();
            int newValue = existValue + 1;
            if (count.compareAndSet(existValue,newValue)) {
                return;
            }
        }
    }

    public void runThread(){
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
                for (int i = 0; i <1000 ; i++) {
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
            t3.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }


    public static void main(String[] args) {
        ThreadAndAtomic ta = new ThreadAndAtomic();
        ta.runThread();
    }
}
