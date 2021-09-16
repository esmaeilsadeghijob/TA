package com.mapsa.phoneBook.database;

import java.util.List;

public interface JdbcCrud<T> {

    String save(T t) throws Exception;
    void updateSubscriberInfo(T t) throws Exception;
    String updateSubscriberPhone(T t,String oldPhoneNumber) throws Exception;
    void delete(T t) throws Exception;
    List<T> findAll() throws Exception;
    T findByPhone(T t) throws Exception;
    List<T> findByNameAndFamily(T t)throws Exception;

}
