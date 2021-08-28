package com.amir.test;

public class User implements Comparable<User>{
    private String name;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName(){
        return this.name;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public int compareTo(User o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name + " " + email;
    }
}
