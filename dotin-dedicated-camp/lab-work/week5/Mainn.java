import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Mainn {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.print("atoosa",29);
        Class a = Test2.class;

        Method[] methods = a.getMethods();
        for (Method method : methods) {
            Annotation[] annotation = method.getAnnotations();
            for (Annotation anno : annotation) {
                if (anno instanceof MyAnot) {
                    System.out.println(method.getParameterCount());
                    MyAnot myAnot = (MyAnot) anno;
                    System.out.println(myAnot.age());
                    System.out.println(myAnot.name());
                }
            }
        }
    }
}
