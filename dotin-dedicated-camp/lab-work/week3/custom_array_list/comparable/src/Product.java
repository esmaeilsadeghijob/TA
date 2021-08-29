public class Product implements Comparable {
    private String name;
    private int price;
    private String category;

    public Product() {
    }

    public Product(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ThisProduct = {" + "name = " + name + " , price = " + price + " , category = " + category + '}';
    }

    @Override
    public int compareTo(Object o) {
        Product p1 = this;
        Product p2 = (Product) o;
        return p1.getName().compareTo(p2.getName());
    }
}
