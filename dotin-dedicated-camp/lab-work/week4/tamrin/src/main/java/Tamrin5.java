import java.util.Random;

public class Tamrin5 {


    lock mylock=new lock() {
        @Override
        public void lock() {

        }

        @Override
        public void unlock() {

        }
    };
    public static void main(String[] args) {
        Tamrin5 test=new Tamrin5();
        test.start();
    }
    private void start(){
        for (int i = 0; i < 10; i++) {
            call();
        }
    }

    Random r = new Random();
    private void call(){
        mylock.lock();
        try {
            int num=r.nextInt(5);
            int result=100/num;
            System.out.println("natije a"+ result);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mylock.unlock();
        }

    }

    public interface lock {
        void lock();
        void unlock();
    }
}
