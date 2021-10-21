package com.mapsa.store;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

protected int id;
protected String nameP;
protected String description;
protected Float price;

    public Product(){ }
    public Product(int id) {
        this.id = id;
    }
    public Product(int id, String nameP, String description, Float price) {
        this(nameP, description, price);
        this.id = id;
    }

    public Product(String nameP, String description, Float price) {
        this.nameP = nameP;
        this.description = description;
        this.price = price;
    }

}
