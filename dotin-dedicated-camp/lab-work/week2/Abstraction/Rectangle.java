package main;

public class Rectangle extends Shape implements Calculataion{
    private int width;
    private int height;


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea(int width, int height) {
        int are = width * height;
        return are;
    }

    @Override
    public int calc() {
        final int area = width * height;
        return area * 100;
    }

    @Override
    public String getInfo() {
        String result = "you have painted a " + color + " Rectangle and you must pay "+ calc()+"$";
        return result;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", color='" + color + '\'' +
                '}';
    }
}
