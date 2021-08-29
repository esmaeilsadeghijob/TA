import java.util.ArrayList;
import java.util.List;

public class GenericClassAndMethod {
    public static void main(String[] args) {
        //generic method
        GenericMethod genericMethod = new GenericMethod(25);
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(15);
        System.out.println("generic method: ");
        System.out.println("num = " + genericMethod.getNumber());
        System.out.print("list = " + genericMethod.listBack(list).get(0) + " , ");
        System.out.println(genericMethod.listBack(list).get(1));

        System.out.println("------------------------------");

        //generic class
        GenericClass<Double> genericClass = new GenericClass<>(97.8);
        System.out.println("generic class: ");
        System.out.println("num = " + (Double) genericClass.getNum());
    }
}
