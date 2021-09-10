package com.mapsa.Mybook.db;

import java.io.IOException;
import java.sql.SQLException;

public interface PerInterface {

    public void add(Person person) throws IOException, SQLException;
    public void delete(int id);
    public void update(Person person);
    public void showAll();
}
