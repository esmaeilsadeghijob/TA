package module;

public class Motorcycle extends Vehicle{
    public Motorcycle(Color color) {
        super(color);
        this.setNumOfWheels(2);
    }

    @Override
    public void abstractMethod() {
        System.out.println("it's a Motorcycle" + " with color: " + getColor().name());
    }
}
