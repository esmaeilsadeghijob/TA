package factory;

import module.Color;

public class FactoryProducer {
    public static AbstractFactory getFactory(Color color){
        switch (color) {
            case RED:
                return new VehicleRedFactory();
            case BLUE:
                return new VehicleBlueFactory();
            default:
                return null;
        }
    }
}
