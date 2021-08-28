import jdk.jfr.StackTrace;

public class Test2 {
    @MyAnot
    public void print(String name, int age) {
        System.out.println(name + " " + age);
    }
}
