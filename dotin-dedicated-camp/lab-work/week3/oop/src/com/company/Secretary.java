package com.company;

public class Secretary extends Employee implements AdministrativeAffairs{
    private String name;
    private String family;
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
    public int getCode() {
        return code;
    }

    @Override
    public void setCode(int code) {
        this.code = code;
    }

    public void setShiftsForPersons(HospitalPerson p){
    }

    public void submitvacations(HospitalPerson p,int countofvcations){
        if (countofvcations>19) System.out.println("dont accept");
        else {
            countofvcations++;
            System.out.println("accepted");
        }
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
}
