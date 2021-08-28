package TA04mapsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ComparableMain {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("apple", 10, "fruit"));
        products.add(new Product("orange",20, "fruit"));
        products.add(new Product("banana", 30, "fruit"));
        products.add(new Product("cabbage", 15, "vegetable"));
        Collections.sort(products);
        System.out.println("The sorted arraylist based on product name:");
        Iterator iterator = products.iterator();
        while(iterator.hasNext())
            System.out.printf(iterator.next().toString() + "%n");

        System.out.println();
        ComparePrice comparePrice = new ComparePrice();
        Collections.sort(products, comparePrice);
        System.out.println("The sorted arraylist based on product price:");
        Iterator iterator2 = products.iterator();
        while(iterator2.hasNext())
            System.out.printf(iterator2.next().toString() + "%n");
    }

}
