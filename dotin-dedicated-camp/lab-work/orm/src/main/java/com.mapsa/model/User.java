package com.mapsa.model;

import com.mapsa.persistence.Column;
import com.mapsa.persistence.Id;
import com.mapsa.persistence.Table;

@Table(name = "users")
public class User {
    @Id
    private long id;
    @Column(dataType = "VARCHAR",length = 20)
    private String username;
    @Column(dataType = "VARCHAR",length = 20)
    private String password;

    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}
