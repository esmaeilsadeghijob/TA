package com.mapsa.test.test.creational.factory;

public class VehicleFactory {

    public enum VehicleTypeEnum {
        CAR,
        MotorCycle
    }

    public static Vehicle createVehicle(VehicleTypeEnum vehicleType) {
        if (vehicleType.equals(VehicleTypeEnum.CAR)) {
            return new Car();
        } else if (vehicleType.equals(VehicleTypeEnum.MotorCycle)){
            return new MotorCycle();
        } else
            return null;
    }
    
}
