import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Press 'T' for Triangle, 'R' for Rectangle, 'S' for Square and 'E' for Exit: ");
            String input = scanner.next();
            if (input.equals("T") || input.equals("t")) {
                System.out.print("Press side: ");
                int side = scanner.nextInt();
                Triangle triangle = new Triangle(side);
                shapeHandler(triangle, scanner);

            } else if (input.equals("R") || input.equals("r")) {
                System.out.print("Press width: ");
                int width = scanner.nextInt();
                System.out.print("Press length: ");
                int length = scanner.nextInt();
                Rectangle rectangle = new Rectangle(length, width);
                shapeHandler(rectangle, scanner);

            } else if (input.equals("S") || input.equals("s")) {
                System.out.print("Press side: ");
                int side = scanner.nextInt();
                Square square = new Square(side);
                shapeHandler(square, scanner);

            } else if (input.equals("E") || input.equals("e")) {
                break;

            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    private static void shapeHandler(Shape shape, Scanner scanner) {
        while (true) {
            System.out.print("Press 'D' for draw shape, 'R' for change scale, 'A' for get area and 'B' for Back: ");
            String command = scanner.next();
            if (command.equals("D") || command.equals("d")) {
                shape.draw();
            }
            else if (command.equals("R") || command.equals("r")) {
                System.out.print("Press 'U' for scale Up and 'D' for scale Down: ");
                char UD = scanner.next().charAt(0);
                System.out.print
                        ("Press scale value: ");
                int scale = scanner.nextInt();
                shape.reScale(UD, scale);
            }
            else if (command.equals("A") || command.equals("a")) {
                System.out.printf("%.1f\n", shape.getArea());
            }
            else if (command.equals("B") || command.equals("b")) {
                break;
            }
            else {
                System.out.println("Invalid input!");
            }
        }
    }
}
