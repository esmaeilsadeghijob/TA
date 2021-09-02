package main;

public abstract class Shape {


    protected String color;


    Shape(){}

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Shape{" +
                ", color='" + color + '\'' +
                '}';
    }
}
