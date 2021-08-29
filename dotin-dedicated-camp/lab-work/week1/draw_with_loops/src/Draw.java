public class Draw {
    public void drawTriangle(int side) {
        for (int i = 1; i <= side; i++) {
            for (int j = i; j < side; j++) //print space
                System.out.print("  ");
            for (int j = 1; j <= side; j++) {
                if (i == side || j == 1 || j == i)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    public void drawRectangle(int length, int width) {
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= width; j++) {
                if (i == 1 || j == 1 || i == length || j == width)
                    System.out.print("*  ");
                else
                    System.out.print("   ");
            }
            System.out.println();
        }
    }

    public void drawSquare(int side) {
        drawRectangle(side, side);
    }

    public void drawDiamond(int side) {
        int num = 2 * side - 1;
        for (int i = 1; i <= side; i++) {
            for (int j = i; j < side; j++) //print space
                System.out.print(" ");
            for (int j = 1; j <= num; j++) {
                if (j == 1 || j == 2 * i - 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = side - 1; i >= 1; i--) {
            for (int j = i; j < side; j++) //print space
                System.out.print(" ");
            for (int j = 1; j <= num; j++) {
                if (j == 1 || j == 2 * i - 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
