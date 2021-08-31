package com.Insurance.dev;

public class Tehran implements Insurance{
    private final double passengersV=200;
    private final double weightV=2;
    private final double meterV=50;
    @Override
    public double InsurancePriceForCar(double passengers) {

        return passengersV*passengers;
    }

    @Override
    public double InsurancePriceForHome(double meter) {

        return meterV*meter;
    }

    @Override
    public double InsurancePriceForMotor(double weight) {

        return weightV*weight;
    }
}
