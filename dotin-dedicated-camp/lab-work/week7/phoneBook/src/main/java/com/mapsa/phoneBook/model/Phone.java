package com.mapsa.phoneBook.model;

public class Phone {

    private long id;
    private String number;
    private PhoneType phoneType;
    private long subsId;

    public long getId() {
        return id;
    }

    public Phone setId(long id) {
        this.id = id;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public Phone setNumber(String number) {
        this.number = number;
        return this;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public Phone setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
        return this;
    }

    public long getSubsId() {
        return subsId;
    }

    public Phone setSubsId(long subsId) {
        this.subsId = subsId;
        return this;
    }
}
