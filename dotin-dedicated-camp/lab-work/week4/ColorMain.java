import java.util.Scanner;

public class ColorMain {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("please enter your shape name.");
        String shape = s.next();
        System.out.println("please enter your shape size in float.");
        float meter = s.nextFloat();
        System.out.println("please enter your desire color.");
        String color = s.next();
        if (shape.equalsIgnoreCase("circle")){
            Circle circle = new Circle();
            circle.setPricePerMeter(300);
            float totalPrice = circle.price(circle.getPricePerMeter(),meter);
            System.out.println("the color of your circle is " + color + " and your total price is " + totalPrice );

        }
        else if (shape.equalsIgnoreCase("rectangle")) {
            Rectangle rectangle = new Rectangle();
            rectangle.setPricePerMeter(100);
            float totalPrice = rectangle.price(rectangle.getPricePerMeter(),meter);
            System.out.println("the color of your circle is " + color + " and your total price is " + totalPrice );

        }
        else if (shape.equalsIgnoreCase("triangle")) {
            Triangle triangle = new Triangle();
            triangle.setPricePerMeter(200);
            float totalPrice = triangle.price(triangle.getPricePerMeter(),meter);
            System.out.println("the color of your circle is " + color + " and your total price is " + totalPrice );

        }

    }
}
