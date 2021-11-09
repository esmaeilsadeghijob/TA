package com.mapsa.onetoonewithsharedprimarykeysample.model.singleTable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Pen extends Product {
    private String color;
    private Pen() {}
    public Pen(String color, String name) {
        this.color = color;
        setName(name);
    }
}
