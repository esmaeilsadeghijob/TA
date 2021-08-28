package com.amir.test;

public class Fishes extends Animal implements Movement{
    //    sorry for the naming variable, if it's not meaningful
    private float depthSwim;

    public Fishes(String name, String type, int speed, float depthSwim) {
        super(name, type, speed);
        this.depthSwim = depthSwim;
    }

    public float getDepthSwim() {
        return depthSwim;
    }

    public void setDepthSwim(float depthSwim) {
        this.depthSwim = depthSwim;
    }

    @Override
    public void eat() {

    }

    @Override
    public void move() {

    }
}
