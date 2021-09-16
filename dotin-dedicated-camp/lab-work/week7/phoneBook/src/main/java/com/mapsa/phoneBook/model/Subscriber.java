package com.mapsa.phoneBook.model;

import com.mapsa.phoneBook.main.Execute;
import java.util.List;

public class Subscriber {
    private long id;
    private String name;
    private String family;
    private List<Phone> phone;

    public Subscriber() {
    }

    public long getId() {
        return id;
    }

    public Subscriber setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Subscriber setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Subscriber setFamily(String family) {
        this.family = family;
        return this;
    }

    public List<Phone> getPhone() {
        return phone;
    }

    public Subscriber setPhone(List<Phone> phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public String toString() {
        String res = Execute.ANSI_YELLOW + "{" +
                "name='" + name + "'" +
                ", family='" + family + "'"+
                ", phone={";

        for (Phone phone : this.phone) {
            res += "[Number='" + phone.getNumber() + "', type ='"+ phone.getPhoneType()+"'] ";
        }

        res += "}";

        return res;
    }
}
