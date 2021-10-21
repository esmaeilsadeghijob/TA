package com.niloofar.orm.JDBC;

import com.niloofar.orm.model.Person;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface MyDao<T> {
    public void add(Object o)throws SQLException;
    public void delete(Object p,int id)throws SQLException;
    public List<T> getAll(Object p)throws SQLException;

    void alter(Object p,TableName tableName) throws SQLException;

    public void update(Object p, int id)throws SQLException;
    public void creat(Object o) throws SQLException;

}
