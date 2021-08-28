 class JoinThread {
     int count = 0;

     public void increment() {
         count++;
     }

     public void runThread(){
         Thread t1 = new Thread(new Runnable() {
             @Override
             public void run() {
                 for (int i = 0; i < 10000; i++) {
                     increment();
                 }
             }
         });

         Thread t2 = new Thread(new Runnable() {
             @Override
             public void run() {
                 for (int i = 0; i < 10000; i++) {
                     increment();
                 }
             }
             });

             Thread t3 = new Thread(new Runnable() {
                 @Override
                 public void run() {
                     for (int i = 0; i <10000 ; i++) {
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
         JoinThread jt = new JoinThread();
         jt.runThread();
     }
 }
