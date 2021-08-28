public class Product {

    private int id;
    private String name;
    private int price;
    private String des;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    private int calculate(int price, int tax) {

        return getPrice() + tax;
    }

    public static void main(String[] args) {

        Product p = new Product();
        p.calculate(1000,5000);
    }
}
