public class Square extends Shape {
    private int side;

    public Square(int side) {
        this.side = side;
        calculateArea();
    }

    @Override
    public void draw() {
        for (int i = 1; i <= side; i++) {
            for (int j = 1; j <= side; j++) {
                if (i == 1 || j == 1 || i == side || j == side)
                    System.out.print("*  ");
                else
                    System.out.print("   ");
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
        setArea(side * side);
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
        calculateArea();
    }
}
