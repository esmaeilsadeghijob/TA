package bmi;

public class Bmi {
    private float height,weight;

    public Bmi(float height, float weight) {
        this.height = height;
        this.weight = weight;
    }

    public float getBmi(){
        return weight/(height*height);
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
