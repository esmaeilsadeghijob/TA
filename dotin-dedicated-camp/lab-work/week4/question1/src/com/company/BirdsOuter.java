package com.company;



public class BirdsOuter {
    private String name;
    private String color;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void fly(int count){
        System.out.println(count+" Birds can fly");
    }

    public class FlyInner {
        public void birdsFly(int count){
            int c=count++;
            fly(c);
        }
    }
}
