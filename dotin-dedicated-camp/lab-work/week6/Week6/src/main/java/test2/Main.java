package test2;

public class Main {
    public static void main(String[] args) {
        Test test = () -> {
            System.out.println("print something");
        };
        test.t();

        Test test1 = () -> Test2.print();
        test1.t();
        Test test2 = () -> new Test2();
        test2.t();
    }
}
