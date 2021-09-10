package module;

public class Bicycle extends Vehicle{
    public Bicycle(Color color) {
        super(color);
        this.setNumOfWheels(2);
    }

    @Override
    public void abstractMethod() {
        System.out.println("it's a Bicycle" + " with color: " + getColor().name());
    }
}
