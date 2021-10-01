package dbconncetion;

import dbconncetion.impl.TableName;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DatabaseService {
    Connection openConnection() throws Exception;

    void closeConnection() throws Exception;

    ResultSet getAll(TableName tableName, String optional) throws SQLException;

    void saveData(TableName tableName, String values) throws Exception;

    void updateData(TableName tableName, String name, String password, long price, long id) throws Exception;
}
