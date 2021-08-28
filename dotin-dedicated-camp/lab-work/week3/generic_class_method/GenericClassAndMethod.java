package TA04mapsa;

import java.util.ArrayList;
import java.util.List;

public class GenericClassAndMethod {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("maryam");
        arrayList.add("reza");
        arrayList.add("ali");
        arrayList.add("fateme");
        GenericMethod methods = new GenericMethod();
        System.out.println(methods.returnString(arrayList));
        System.out.println();

        List list = new ArrayList();
        list.add(new Product("apple", 1000, "fruit"));
        list.add(new Product("Orange", 2000, "fruit"));
        list.add(new String("MARYAM"));
        System.out.println(methods.returnGenericType(list));
        System.out.println();

        GenericClass<Integer> genericClassInteger = new GenericClass<>(1);
        GenericClass<Double> genericClassDouble = new GenericClass<>(2.5);
        System.out.println(genericClassInteger.returnGenericType().toString());
        System.out.println(genericClassDouble.returnGenericType().toString());
    }
}
