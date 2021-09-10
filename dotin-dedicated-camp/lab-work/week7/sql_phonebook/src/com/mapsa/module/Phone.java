package com.mapsa.module;

public class Phone {
    private int contactId;
    private String phoneNumber;
    private String lastPhoneNumber;

    public Phone(int contactId, String phoneNumber) {
        this.contactId = contactId;
        setPhoneNumber(phoneNumber);
        this.lastPhoneNumber = this.phoneNumber;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.lastPhoneNumber = this.phoneNumber;
//        if (phoneNumber.startsWith("+") && phoneNumber.length() == 13)
        this.phoneNumber = phoneNumber;
//        else
//            this.phoneNumber = "+989351234567";
    }

    public int getContactId() { return contactId; }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLastPhoneNumber() { return lastPhoneNumber; }

}
