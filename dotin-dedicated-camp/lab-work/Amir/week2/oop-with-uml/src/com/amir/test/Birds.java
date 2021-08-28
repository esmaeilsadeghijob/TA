package com.amir.test;

public class Birds extends Animal implements Movement{
    private float flightHeight;

    public Birds(String name, String type, int speed, float flightHeight) {
        super(name, type, speed);
        this.flightHeight = flightHeight;
    }

    public float getFlightHeight() {
        return flightHeight;
    }

    public void setFlightHeight(float flightHeight) {
        this.flightHeight = flightHeight;
    }

    @Override
    public void eat() {

    }

    @Override
    public void move() {
        System.out.println("fly");
    }
}
