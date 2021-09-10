package application;

import factory.AbstractFactory;
import factory.FactoryProducer;
import module.Color;
import module.VehicleType;

public class Main {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = FactoryProducer.getFactory(Color.RED);
        abstractFactory.getVehicle(VehicleType.CAR).abstractMethod();
        abstractFactory.getVehicle(VehicleType.MOTORCYCLE).abstractMethod();
        abstractFactory.getVehicle(VehicleType.BICYCLE).abstractMethod();
        System.out.println("---------------------------------------------");
        abstractFactory = FactoryProducer.getFactory(Color.BLUE);
        abstractFactory.getVehicle(VehicleType.CAR).abstractMethod();
        abstractFactory.getVehicle(VehicleType.MOTORCYCLE).abstractMethod();
        abstractFactory.getVehicle(VehicleType.BICYCLE).abstractMethod();
    }
}
