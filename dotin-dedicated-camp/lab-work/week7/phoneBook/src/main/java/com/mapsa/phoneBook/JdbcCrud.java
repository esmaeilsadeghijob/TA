package com.mapsa.phoneBook;

import java.sql.SQLException;
import java.util.List;

public interface JdbcCrud<T> {

    boolean save(T t) throws SQLException, Exception;
    void updateSubscriberInfo(T t) throws SQLException;
    boolean updateSubscriberPhone(T t,String oldPhoneNumber) throws SQLException;
    void delete(T t) throws SQLException;
    List<T> findAll() throws SQLException;
    T findByPhone(T t) throws SQLException;
    List<T> findByNameAndFamily(T t)throws SQLException;

}
