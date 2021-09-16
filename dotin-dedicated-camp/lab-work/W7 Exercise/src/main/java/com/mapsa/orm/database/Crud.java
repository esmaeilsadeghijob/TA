package com.mapsa.orm.database;

import java.io.IOException;
import java.sql.SQLException;

public interface Crud {

    void createTable(Object object) throws SQLException, IOException;
    void addRecord(Object object) throws SQLException, IOException;
    void showRecord(Object object) throws SQLException, IOException;
    void deleteRecord(Object object) throws SQLException, IOException;
    void updateRecord(Object object) throws SQLException, IOException;
    void showAllRecord(Object object) throws SQLException, IOException;

}
