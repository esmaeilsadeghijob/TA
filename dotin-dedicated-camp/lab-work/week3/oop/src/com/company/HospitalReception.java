package com.company;

public abstract class HospitalReception extends Employee implements AdministrativeAffairs{
    private String name;
    private String family;
    private int code;
    private String unit;

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

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getUnit() {
        return unit;
    }

    @Override
    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public void admissionOfPatients() {

    }

    @Override
    public void booktimeForPatients() {

    }

    @Override
    public void answeringThePhone() {

    }

    public abstract void guidingPatients();

    @Override
    public void print(){
        System.out.println("hospitalreception");
    }
}
