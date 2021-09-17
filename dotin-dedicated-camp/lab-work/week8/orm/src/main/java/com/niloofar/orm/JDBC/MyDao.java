package com.niloofar.orm.JDBC;

import com.niloofar.orm.model.Person;

import java.sql.SQLException;
import java.util.List;

public interface MyDao {
    public int add(Person p)throws SQLException;
    public void delete(Person p,int id)throws SQLException;
    public List<Person> getAll(Person p)throws SQLException;
    public void update(Person p,int id)throws SQLException;
    public void creat(Object o) throws SQLException;
}
