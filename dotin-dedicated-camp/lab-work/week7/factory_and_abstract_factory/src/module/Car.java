package module;

public class Car extends Vehicle{
    public Car(Color color) {
        super(color);
        this.setNumOfWheels(4);
    }

    @Override
    public void abstractMethod() {
        System.out.println("it's a Car" + " with color: " + getColor().name());
    }
}
