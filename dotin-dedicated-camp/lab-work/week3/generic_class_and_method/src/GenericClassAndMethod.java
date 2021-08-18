import java.util.ArrayList;
import java.util.List;

public class GenericClassAndMethod {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("D");

        List<Integer> list2 = new ArrayList<>();
        list2.add(10);
        list2.add(20);
        list2.add(30);
        list2.add(40);

        GenericMethod genericMethod = new GenericMethod();
        genericMethod.num = 9;
        System.out.println(genericMethod.integer_ge());
        System.out.println(genericMethod.listpooya(list1));
        System.out.println(genericMethod.listpooya(list2));
    }
}
