package com.mapsa.test.test.creational.abstractFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(FactoryName name) {
        if (name.equals(FactoryName.Vehicle)) {
            return new VehicleAbstractFactory();
        } else if (name.equals(FactoryName.Color)) {
            return new ColorFactory();
        } else
            return null;
    }

    public enum FactoryName {
        Color,
        Vehicle
    }
}
