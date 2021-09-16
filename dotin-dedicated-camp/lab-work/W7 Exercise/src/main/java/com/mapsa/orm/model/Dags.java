package com.mapsa.orm.model;

import com.mapsa.orm.annotation.Column;
import com.mapsa.orm.annotation.Id;
import com.mapsa.orm.annotation.Table;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Table(name = "Dags")
public class Dags implements Objects{

    @Id
    @Column(name = "dagNumber", dataType = "integer", length = 50)
    private int dagNumber;
    @Column(name = "dogBreed", dataType = "VARCHAR", length = 100)
    private String dogBreed;
    @Column(name = "dagName", dataType = "VARCHAR", length = 35)
    private String dagName;

    @Override
    public void display() {
        System.out.println("dog " + getDagNumber() + " Dog Bread: " + getDogBreed() + " Dag Name " + getDagName());
    }
}
