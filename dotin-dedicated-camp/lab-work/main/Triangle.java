package main;

public class Triangle extends Shape implements Calculataion{
    private int base;
    private int chord;


    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getChord() {
        return chord;
    }

    public void setChord(int chord) {
        this.chord = chord;
    }

    @Override
    public int calc() {
        int area = (base * chord)/2;
        return area * 300;
    }

    @Override
    public String getInfo() {
        String result = "you have painted a " + color +" Triangle Shape"+ "and you must pay"+ "\t" + calc() + "$";
        return result;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                ", color='" + color + '\'' +
                ", base=" + base +
                ", chord=" + chord +
                '}';
    }
}
