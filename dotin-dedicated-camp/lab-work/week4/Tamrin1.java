package Week4;

public class Tamrin1 {

    void show() {
        System.out.println("this is outer class");
    }
    static class Tamrin1_Inner {

        void show() {
            System.out.println("this is inner class");
        }
    }

    public static void main(String[] args) {
        Tamrin1 t = new Tamrin1();
        t.show();
        Tamrin1_Inner ti = new Tamrin1_Inner();
        ti.show();
    }
}
