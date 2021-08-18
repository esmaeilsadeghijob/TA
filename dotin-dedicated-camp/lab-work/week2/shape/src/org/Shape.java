package org;

public class Shape {
    public void square(int length) {
        int squareLength = length;
        for (int i = 0; i < squareLength; i++) {
            for (int j = 1; j < squareLength; j++) {
                System.out.print("* ");
            }
            System.out.println("*");
        }
    }
    public void rectangle(int length,int width) {
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < width; j++) {
                System.out.print("* ");
            }
            System.out.println("*");
        }
    }
    public void triangle(int length) {
        int triangleLength=length;
        for (int i = 0; i <triangleLength ; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println("* ");
        }
    }
    public void lozenge (int length){
        int k = 2*length - 2;
        for (int i=0; i<length-1; i++)
        {
            for (int j=0; j<k; j++)
            {
                System.out.print(" ");
            }
            k = k - 1;

            for (int x=0; x<=i; x++ )
            {
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i = length;i > 0; i--) {
            for (int j=k; j>0; j--)
            {
                System.out.print(" ");
            }
            k = k + 1;

            for (int x=i; x>0; x-- )
            {
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}
