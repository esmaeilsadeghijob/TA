package com.mapsa.test.test.creational.abstractFactory;

import com.mapsa.test.test.creational.factory.Car;
import com.mapsa.test.test.creational.factory.MotorCycle;
import com.mapsa.test.test.creational.factory.Vehicle;

public class VehicleAbstractFactory extends AbstractFactory {

    public enum VehicleTypeEnum {
        CAR,
        MotorCycle
    }

    public Vehicle createVehicle(VehicleTypeEnum vehicleType) {
        if (vehicleType.equals(VehicleTypeEnum.CAR)) {
            return new Car();
        } else if (vehicleType.equals(VehicleTypeEnum.MotorCycle)){
            return new MotorCycle();
        } else
            return null;
    }

}