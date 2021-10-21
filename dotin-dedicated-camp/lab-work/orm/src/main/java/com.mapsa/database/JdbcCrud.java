package com.mapsa.database;

import java.sql.SQLException;
import java.util.List;

public interface JdbcCrud<T> {
    void create(T t) throws Exception;

    void save(T t) throws Exception;

    void update(T t) throws Exception;

    void delete(T t) throws Exception;

    List<T> selectAll(Class<T> tClass) throws Exception;

    T selectById(Class<T> tClass, Long id) throws Exception;

    void close() throws SQLException;
}
