public class Main {
    public static void main(String[] args) {
        Shape shape = Shape.DIAMOND;

        switch (shape) {
            case DIAMOND:
                shape.drawDiamond(5);
                break;
            case SQUARE:
                shape.drawSquare(5);
                break;
            case RECTANGLE:
                shape.drawRectangle(3,5);
                break;
            case TRIANGLE:
                shape.drawTriangle(5);
                break;
        }
    }
}

