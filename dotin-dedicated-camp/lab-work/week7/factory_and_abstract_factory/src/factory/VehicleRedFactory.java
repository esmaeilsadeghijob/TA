package factory;

import module.*;

public class VehicleRedFactory extends AbstractFactory{
    @Override
    public Vehicle getVehicle(VehicleType vehicleType) {
        switch (vehicleType) {
            case CAR:
                return new Car(Color.RED);
            case MOTORCYCLE:
                return new Motorcycle(Color.RED);
            case BICYCLE:
                return new Bicycle(Color.RED);
            default:
                return null;
        }
    }
}
