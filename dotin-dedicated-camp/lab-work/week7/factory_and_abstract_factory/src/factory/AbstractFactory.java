package factory;

import module.Vehicle;
import module.VehicleType;

public abstract class AbstractFactory {
    public abstract Vehicle getVehicle(VehicleType vehicleType);
}
