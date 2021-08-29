public abstract class Shape implements Drawable {
    private float area;

    public abstract void calculateArea();

    public void setArea(float area) {
        this.area = area;
    }

    public float getArea() {
        return area;
    }
}
