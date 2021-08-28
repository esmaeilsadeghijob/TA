import java.util.Comparator;

public class CompareProduct implements Comparable<CompareProduct> {

    private String name;
    private int price;

    public CompareProduct(String name, int price) {
        this.name = name;
        this.price = price;
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
        return "CompareProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }


    @Override
    public int compareTo(CompareProduct o) {
        if (price == o.getPrice()) {
            return 0;
        } else if (price > o.getPrice()) {
            return 1;
        } else
            return -1;
    }
    
}
