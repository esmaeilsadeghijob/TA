package com.company;

public abstract class Nurse extends HospitalPerson{
    private String name;
    private String family;
    private String jensiat;
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

    @Override
    public String getJensiat() {
        return jensiat;
    }

    @Override
    public void setJensiat(String jensiat) {
        this.jensiat = jensiat;
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

    public abstract void takingCareOfPatients();
}
