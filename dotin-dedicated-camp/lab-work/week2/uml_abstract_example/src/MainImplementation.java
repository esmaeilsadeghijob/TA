public class MainImplementation extends MainAbstract {

    public MainImplementation(int price, String name) {
        super(price, name);
    }

    @Override
    public int calculatePrice() {
        int price = getPrice();
        price += (price * 0.2);
        setPrice(price);
        return price;
    }
}
