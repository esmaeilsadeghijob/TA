package com.company.mian;

import com.company.enumtest.EnumTest;

public class Main {

    public static void main(String[] args) {

//        OuterClass.innerclass outerClass = new OuterClass(). new innerclass();
//        outerClass.display();

//        Exceptions nullException = new Exceptions(null);
//        System.out.println(nullException.isFive());

//        Resource resource = new Resource();
//        resource.display();

//        MultiException multiException = new MultiException();
//        multiException.display();

        EnumTest mySkill = EnumTest.INTERMEDIATE;
        switch (mySkill) {
            case BEGINNER:
                System.out.println("Beginner");
                break;
            case INTERMEDIATE:
                System.out.println("Intermediate");
                break;
            case PROFICIENT:
                System.out.println("Proficient");
                break;
            case EXPERT:
                System.out.println("Expert");
        }

    }
}
