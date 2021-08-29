public abstract class MainAbstract implements MainInterface {
    private int price;
    private String name;

    public MainAbstract(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String foodName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
}
