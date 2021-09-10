package com.mapsa.phoneBook;

public class Subscriber {
    private long id;
    private String name;
    private String family;
    private String phone;

    public Subscriber() {
    }

    public Subscriber(long id, String name, String family, String phone) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public Subscriber setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public String toString() {
        return Main.ANSI_YELLOW + "{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
