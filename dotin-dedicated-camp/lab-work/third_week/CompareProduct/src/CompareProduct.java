import java.util.Comparator;

public class CompareProduct implements Comparator {

    String name;
    int price;


    public CompareProduct(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public CompareProduct() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CmpareProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }



    @Override
    public int compare( CompareProduct compareProduct1 , ) {
        if()
    }
}
