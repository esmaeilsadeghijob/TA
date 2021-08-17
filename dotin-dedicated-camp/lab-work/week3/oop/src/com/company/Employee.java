package com.company;

public class Employee extends HospitalPerson{
    private String name;
    private String family;
    private String unit;
    private int countofvcations=0;
    private int code;


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getFamily() {
        return family;
    }

    @Override
    public void setFamily(String family) {
        this.family = family;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public int getCountofvcations() {
        return countofvcations;
    }

    @Override
    public void setCountofvcations(int countofvcations) {
        this.countofvcations = countofvcations;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
