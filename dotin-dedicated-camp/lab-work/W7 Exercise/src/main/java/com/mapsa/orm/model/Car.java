package com.mapsa.orm.model;

import com.mapsa.orm.annotation.Column;
import com.mapsa.orm.annotation.Id;
import com.mapsa.orm.annotation.Table;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Table(name = "Car")
public class Car implements Objects {

    @Id
    @Column(name = "CarId", dataType = "integer", length = 50)
    private int carId;
    @Column(name = "CompanyName", dataType = "VARCHAR", length = 25)
    private String carCompanyName;
    @Column(name = "ModelName", dataType = "VARCHAR", length = 35)
    private String carModelName;

    @Override
    public void display() {
        System.out.println("Id " + getCarId() + " Company Name: " + getCarCompanyName() + " Model Name " + getCarModelName());
    }
}
