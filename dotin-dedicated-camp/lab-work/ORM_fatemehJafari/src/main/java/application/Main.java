package application;

import database.CRUDImp;
import model.Car;

public class Main {

    public static void main(String[] args) throws Exception {


        Car car = new Car(1,"fatemeh", "jafari");
        CRUDImp crudImp = new CRUDImp(Car.class);
        crudImp.create();
//        crudImp.addRecord(car);
//        crudImp.update(car, 1);
        crudImp.deleteRow(car, 1);

    }
}
