public class Triangle extends Shape {
    private int side;

    public Triangle(int side) {
        this.side = side;
        calculateArea();
    }

    @Override
    public void draw() {
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

    @Override
    public void reScale(char UD, int scale) {
        if (UD == 'U' || UD == 'u')
            side *= scale;
        else if (UD == 'D'|| UD == 'd')
            side /= scale;
        System.out.println();
        draw();
        calculateArea();
    }

    @Override
    public void calculateArea() {
        setArea((((float) (side * side)) / 2));
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        calculateArea();
        this.side = side;
    }
}
