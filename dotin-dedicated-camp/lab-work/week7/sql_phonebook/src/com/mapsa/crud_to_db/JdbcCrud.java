package com.mapsa.crud_to_db;

import java.sql.SQLException;
import java.util.List;

public interface JdbcCrud<T, E> {
    void save(T t) throws SQLException;
    void update(T t) throws SQLException;
    List<T> findAll() throws SQLException;
    T findById(E e) throws SQLException;
    void delete(T t) throws SQLException;
}
