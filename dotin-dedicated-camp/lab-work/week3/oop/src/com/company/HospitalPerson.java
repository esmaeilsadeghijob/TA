package com.company;

public class HospitalPerson {
    private   String name;
    private   String family;
    private   String jensiat;
    private String speciality;
    private int countofvcations=0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getJensiat() {
        return jensiat;
    }

    public void setJensiat(String jensiat) {
        this.jensiat = jensiat;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getCountofvcations() {
        return countofvcations;
    }

    public void setCountofvcations(int countofvcations) {
        this.countofvcations = countofvcations;
    }

    public void print(){
        System.out.println("hospitalpersons");
    }
}
