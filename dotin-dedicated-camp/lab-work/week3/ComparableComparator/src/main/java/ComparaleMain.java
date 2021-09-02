
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparaleMain {
    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Orange", 100, "fruit"));
        productList.add(new Product("Pineapple", 500, "fruit"));
        productList.add(new Product("Apple", 200, "fruit"));

        Collections.sort(productList);

        for (Product product : productList) {
            System.out.println(product.getName() + " " + product.getPrice());
        }

    }
}