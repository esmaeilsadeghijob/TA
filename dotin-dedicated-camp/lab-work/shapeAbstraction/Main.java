package main;

import javafx.scene.shape.Circle;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Rectangle recctangle = new Rectangle();
        Triangle triangle = new Triangle();
        Dayere dayere = new Dayere();


        System.out.println("Choose a Shape please\n" +
                "(1=Circle) | (2=Rectangle) | (3=Triangle)\n");
            long  num = sc.nextLong();
            if ( num == 1){
            System.out.println("Enter Your color plz");
            dayere.setColor(sc.next());

            System.out.println("Enter Your Radius please: ");

            dayere.setRadius(sc.nextInt());
            System.out.println(dayere.getInfo());


        }else if( num == 2){
            System.out.println("Enter Your color plz");
            recctangle.setColor(sc.next());

            System.out.println("Enter Your width and height please: ");

            recctangle.setWidth(sc.nextInt());
            recctangle.setHeight(sc.nextInt());
            System.out.println(recctangle.getInfo());
        }else if(num == 3){
            System.out.println("Enter Your color plz");
            triangle.setColor(sc.next());

            System.out.println("Enter Your Base and Chord please: ");

            triangle.setBase(sc.nextInt());
            triangle.setChord(sc.nextInt());
            System.out.println(triangle.getInfo());
        }else{
                System.out.println("You have entered invalid data");
            }


    }
}
