package com.amir.test;

public class Eagle extends Birds implements Foods {
    String color;

    public Eagle(String name, String type, int speed, float flightHeight, String color) {
        super(name, type, speed, flightHeight);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void foodType() {

    }
}
