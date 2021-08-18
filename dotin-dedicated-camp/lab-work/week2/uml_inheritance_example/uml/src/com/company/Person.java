package com.company;

public abstract class Person {
    private String username;
    private String password;
    private String age;
    private int phonenumber;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    private void block() {
        System.out.println("user blocked");
    }

    private void unblock() {
        System.out.println("user blocked");
    }

    protected abstract void save();
    protected abstract void delete();

}
