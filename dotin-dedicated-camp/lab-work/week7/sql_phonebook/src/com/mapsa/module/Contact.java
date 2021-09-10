package com.mapsa.module;

import java.util.HashMap;
import java.util.Map;

public class Contact {
    private int id;
    private int lastId;
    private String firstname;
    private String lastname;
    private Map<String, Phone> phoneNumbers;

    public Contact(int id, String firstname, String lastname) {
        this.id = id;
        this.lastId = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumbers = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public int getLastId() { return lastId; }

    public String getFirstname() { return firstname; }

    public String getLastname() { return lastname; }

    public Map<String, Phone> getPhoneNumbers() { return phoneNumbers; }

    public void setId(int id) {
        this.lastId = this.id;
        this.id = id;
    }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public boolean addPhone(Phone phoneNumber) {
        if (phoneNumbers.containsKey(phoneNumber.getPhoneNumber()))
            return false;
        phoneNumbers.put(phoneNumber.getPhoneNumber(),phoneNumber);
        return true;
    }

    @Override
    public String toString() {
        String result = "Contact = { " + "id : " + id +
                ", firstname : '" + firstname + '\'' +
                ", lastname : '" + lastname + '\'';
        if (!this.phoneNumbers.isEmpty()) {
            result += ", phoneNumbers : {";
            for (Map.Entry<String, Phone> entry:phoneNumbers.entrySet()) {
                result += (entry.getKey() + ", ");
            }
            if (result.endsWith(", "))
                result = result.substring(0, result.length() - 2);
            result += "}}";
        }
        else
            result += "}";
        return result;
    }
}
