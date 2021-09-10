package factory;

import module.*;

public class VehicleBlueFactory extends AbstractFactory{
    @Override
    public Vehicle getVehicle(VehicleType vehicleType) {
        switch (vehicleType) {
            case CAR:
                return new Car(Color.BLUE);
            case MOTORCYCLE:
                return new Motorcycle(Color.BLUE);
            case BICYCLE:
                return new Bicycle(Color.BLUE);
            default:
                return null;
        }
    }
}
