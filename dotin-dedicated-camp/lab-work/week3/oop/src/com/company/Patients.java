package com.company;

public abstract class Patients extends HospitalPerson{
    private  String name;
    private  String family;
    private  String jensiat;

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

    public abstract void dischargeFromTheHospital(HospitalPerson p);
    public abstract void Hospitalization(HospitalPerson p);
}
