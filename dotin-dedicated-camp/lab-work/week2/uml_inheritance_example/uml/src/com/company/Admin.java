package com.company;

public abstract class Admin extends Person implements PersAct{
    private String id;
    private String name;
    private String phone;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void block() {
        System.out.println("user blocked");
    }

    @Override
    public void unblock() {
        System.out.println("user unblocked");
    }

    @Override
    public void add() {
        System.out.println("user added");
    }

    @Override
    public void delete() {
        System.out.println("user deleted");
    }
}
