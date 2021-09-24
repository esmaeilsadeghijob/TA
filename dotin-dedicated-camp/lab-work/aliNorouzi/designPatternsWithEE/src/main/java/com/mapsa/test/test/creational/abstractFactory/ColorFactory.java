package com.mapsa.test.test.creational.abstractFactory;

public class ColorFactory extends AbstractFactory{
    public enum ColorShade{
        RED,
        GREEN
    }

    public static Color createColor(ColorShade shade) {
        if (shade.equals(ColorShade.RED)) {
            return new Red();
        } else if (shade.equals(ColorShade.GREEN)) {
            return new Green();
        } else
            return null;
    }
}
