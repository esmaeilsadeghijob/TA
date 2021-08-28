import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        RefExp r = new RefExp();
        Class a = RefExp.class;
        Field field;
        Field f2;
        for (Field f:a.getDeclaredFields()) {
            f.setAccessible(true);
            System.out.println("f: " + f.getName());
        }
        field = RefExp.class.getDeclaredField("name");
        f2 = RefExp.class.getDeclaredField("lastName");
        field.setAccessible(true);
        field.set(r,"anahita");
        f2.setAccessible(true);
        f2.set(r,"makvandi");
        System.out.println(r.toString());
        Method method;
        Method m1 = RefExp.class.getDeclaredMethod("bye", String.class);
        m1.invoke(r,"bye");
        System.out.println("fsg: " + m1);
        for (Method m:a.getDeclaredMethods()) {
            m.setAccessible(true);
            System.out.println("m: " + m.getName());
        }
        Method method2;
        for (Method m:a.getMethods()) {
            m.setAccessible(true);
            System.out.println("m2: " + m.getName());
        }

        Constructor constructor;
        for (Constructor c:a.getDeclaredConstructors()) {
            c.setAccessible(true);
            System.out.println("c: " + c.getName());
        }
    }
}
