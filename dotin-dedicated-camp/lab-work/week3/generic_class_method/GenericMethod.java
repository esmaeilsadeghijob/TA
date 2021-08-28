package TA04mapsa;

import java.util.ArrayList;
import java.util.List;

public class GenericMethod {
    public <String> List returnString(ArrayList<String> arraylist){
        System.out.printf("Arraylist received:%n%s", arraylist);
        System.out.printf("%nreturning arraylist to the caller:%n");
        return arraylist;
    }

    public <E> E returnGenericType(E object){
        System.out.printf("Object received:%n%s", object);
        System.out.printf("%nreturning object to the caller:%n");
        return object;
    }
}
