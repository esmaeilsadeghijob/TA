package com.main;

import human.User;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcom To Our World");

        User user = new User("hmd","khlili","Hmd",90573,9);
        user.save();
        System.out.println(user);
    }
}
