import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<CompareProduct> products = new ArrayList<>();
        ArrayList<CompareProduct> delProducts = new ArrayList<>();

        products.add(new CompareProduct("pinaple", 100));
        products.add(new CompareProduct("Banana", 120));

        delProductsproducts.add(new CompareProduct("Banana", 120));
        Collections.sort(products);
        for (CompareProduct compareProduct : products){
            System.out.println(compareProduct.getName()+"    "+ compareProduct.getPrice());
        }
    }
}
