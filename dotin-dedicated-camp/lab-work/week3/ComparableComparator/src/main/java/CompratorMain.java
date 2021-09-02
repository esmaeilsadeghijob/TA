import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CompratorMain {

        public static void main(String[] args) {

            List<Product> productList = new ArrayList<>();
            productList.add(new Product("Orange", 10,"fruit"));
            productList.add(new Product("Pineapple",50,"fruit"));
            productList.add(new Product("Apple", 30,"fruit"));

            Collections.sort(productList,new CompareName());
            /*Collections.sort(productList,new CompareBaseOnPrice());*/

            for (Product product : productList) {
                System.out.println(product.getName()+" "+product.getPrice());
            }

        }
    }
