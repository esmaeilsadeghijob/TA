package com.Insurance.dev;



public class scan {

private double home ;
private double motor;
private double car;
private int discountCode;


    public void setCar(double car) {
        this.car = car;
    }

    public void setDiscountCode(int discountCode) {
        this.discountCode = discountCode;
    }

    public void setHome(double home) {
        this.home = home;
    }

    public void setMotor(double motor) {
        this.motor = motor;
    }

    public int getDiscountCode() {
        return discountCode;
    }

    public double getCar() {
        return car;
    }

    public double getHome() {
        return home;
    }

    public double getMotor() {
        return motor;
    }
}
