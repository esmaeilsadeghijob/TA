public class Rectangle extends Shape {
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
        calculateArea();
    }

    @Override
    public void draw() {
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

    @Override
    public void reScale(char UD, int scale) {
        if (UD == 'U' || UD == 'u') {
            length *= scale;
            width *= scale;
        }
        else if (UD == 'D'|| UD == 'd'){
            length /= scale;
            width /= scale;
        }
        System.out.println();
        draw();
        calculateArea();
    }

    @Override
    public void calculateArea() {
        setArea(length * width);
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public void setLength(int length) {
        calculateArea();
        this.length = length;
    }

    public void setWidth(int width) {
        calculateArea();
        this.width = width;
    }
}

