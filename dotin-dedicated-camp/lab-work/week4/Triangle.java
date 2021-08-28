public class Triangle implements CalculatePrice {

    private float pricePerMeter;

    public float getPricePerMeter() {
        return pricePerMeter;
    }

    public void setPricePerMeter(float pricePerMeter) {
        this.pricePerMeter = pricePerMeter;
    }

    @Override
    public float price(float pricePerMeter, float meter) {
        return getPricePerMeter()*meter;
    }
}
