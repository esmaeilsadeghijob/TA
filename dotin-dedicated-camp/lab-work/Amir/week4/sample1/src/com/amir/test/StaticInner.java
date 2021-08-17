package com.amir.test;

public class StaticInner {
    public static void main(String[] args) {
        Outer2.InnerStatic out2 = new Outer2.InnerStatic();
        out2.sayMsg();

    }
}

class Outer2 {

    static String msg = "Hello";
    int num = 20;

    static class InnerStatic {
        void sayMsg() {
            System.out.println(msg);
        }
    }
}
