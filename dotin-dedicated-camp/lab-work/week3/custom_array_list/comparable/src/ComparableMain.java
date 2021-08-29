import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableMain {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("pasta", 15000, "food"));
        products.add(new Product("room", 1200, "book"));
        products.add(new Product("javaSE", 2000, "cd"));
        products.add(new Product("rose", 30000, "flower"));

        System.out.println("before sort :");
        for (Product p : products)
            System.out.println(p.toString());

        Collections.sort(products);

        System.out.println("----------------------");

        System.out.println("after sort :");
        for (Product p : products)
            System.out.println(p.toString());

    }
}

