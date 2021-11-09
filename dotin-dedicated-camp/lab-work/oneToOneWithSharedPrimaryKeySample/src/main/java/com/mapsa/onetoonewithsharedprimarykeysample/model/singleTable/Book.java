package com.mapsa.onetoonewithsharedprimarykeysample.model.singleTable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Book extends Product {
    private String author;

    private Book () {}
    public Book(String name, String author) {
        this.author = author;
        setName(name);
    }
}
