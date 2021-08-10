import java.lang.reflect.Array;
import java.util.Arrays;

public class Tamrin2 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        String[] b = new String[]{"ana", "anahita","atoosa","shokoufeh"};
        Array[] c = new Array[5];
        System.out.println(a.length);
        System.out.println(b.length);
        System.out.println(c.length);
        System.out.println(a.clone());
        System.out.println(b.clone());
        System.out.println(c.clone());
        System.out.println(a.equals(new int[]{1, 2, 3, 4, 5}));
        System.out.println(b.equals("ana"));
        System.out.println(c.equals(5));
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        System.out.println(a.hashCode());
        System.out.println(a.getClass());
        System.out.println(b.hashCode());
        System.out.println(b.getClass());
        System.out.println(c.hashCode());
        System.out.println(c.getClass());


    }

}
