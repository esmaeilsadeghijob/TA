package com.amir.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<User> list = new ArrayList<>();
        list.add(new User("zahra","a"));
        list.add(new User("ali", "c"));
        list.add(new User("behzad","b"));


        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);


        System.out.println("------------------------------");
        System.out.println("sort by email");
        Collections.sort(list, new CompratorSample());
        System.out.println(list);
        System.out.println("------------------------------");
        System.out.println("sort by name");
        Collections.sort(list,new CompareName());
        System.out.println(list);


    }


    }

class CompareName implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
