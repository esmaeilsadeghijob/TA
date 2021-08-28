package com.amir.test;

public abstract class Animal {
    private String name,type;
    private int speed;

    public Animal(String name, String type, int speed) {
        this.name = name;
        this.type = type;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public abstract void eat();
}
