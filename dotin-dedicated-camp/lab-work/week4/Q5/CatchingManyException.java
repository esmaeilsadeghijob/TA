package homeworks;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CatchingManyException {
    public static void main(String[] args) {
        List animalList = new ArrayList();
        animalList.add(new Dog());
        animalList.add(new Cat());
        animalList.add("hi animal");
        animalList.add(2);
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Enter the index you want to get:");
            int i = scanner.nextInt();
            System.out.printf("getting the index number %d and invoking the method talk:%n",i);
            Animal animal = (Animal) animalList.get(i);
            animal.talk();
        }catch(IndexOutOfBoundsException e){
            System.out.println("The index is out of bound of the arraylist.");
            e.printStackTrace();
        }catch(ClassCastException e){
            System.out.println("Can not cast the object to animal class");
            e.printStackTrace();
        }catch (InputMismatchException e){
            System.out.println("The input index must be an integer.");
            e.printStackTrace();
        }
    }
}
