package main;

public class Dayere extends Shape implements Calculataion{

    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public int calc() {
       int area = (int) (Math.PI*Math.pow(radius,2));
       return area * 500;
    }

    @Override
    public String getInfo() {
        String result = "you have painted a " + color + "\t"+"Circle  Shape and you must pay"+"\t" + calc()+"$" ;
        return result;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
