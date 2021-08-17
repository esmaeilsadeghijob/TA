package com.amir.test;

class Outer {
    private int num = 17;
    // inner class
    public class Inner {
        public int getNum() {
            System.out.print("y is : ");
            return num;
        }
    }
}

public class Main{

    public static void main(String args[]) {
        // Instantiating the outer class
        Outer outer = new Outer();

        // Instantiating the inner class
        Outer.Inner inner = outer.new Inner();
        System.out.println(inner.getNum());
    }
}
