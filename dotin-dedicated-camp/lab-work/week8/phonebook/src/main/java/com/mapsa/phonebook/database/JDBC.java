package com.mapsa.phonebook.database;

import java.util.Map;

public interface JDBC<T> {
    void create(T phoneNumber, T fullName);

    void readByName(T fullName);
    void readByPhoneNumber(T phoneNumber);

    void update(T phoneNumber, T fullName);

    void deleteByPhoneNumber(T phoneNumber);
    void deleteByName(T fullName);

    Map<T,T> getAll();
}
