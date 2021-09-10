package module;

public abstract class Vehicle {
    private int numOfWheels;
    private Color color;

    public Vehicle(Color color) {
        this.color = color;
    }

    public void setNumOfWheels(int numOfWheels) {
        this.numOfWheels = numOfWheels;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getNumOfWheels() {
        return numOfWheels;
    }

    public Color getColor() {
        return color;
    }

    public abstract void abstractMethod();
}
