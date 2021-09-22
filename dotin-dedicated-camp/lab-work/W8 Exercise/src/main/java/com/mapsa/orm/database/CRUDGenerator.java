package com.mapsa.orm.database;


import com.mapsa.orm.databaseworktools.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;


public class CRUDGenerator implements Crud {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    Scanner scanner;
    Statement statement;
    Connection connection;
    DBConnection dbConnection;
    PreparedStatement preparedStatement;

    public CRUDGenerator() throws IOException, SQLException {

        scanner = new Scanner(System.in);
        dbConnection = DBConnection.getInstance();
        connection = dbConnection.getConnection();
        statement = connection.createStatement();

    }

    @Override
    public void addRecord(Object object) throws SQLException, IOException {

        Tools tools = new AddRecord();
        ((AddRecord) tools).addRecordToTable(object);

    }

    @Override
    public void showRecord(Object object) throws SQLException, IOException {

        Tools tools = new ShowRecord();
        ((ShowRecord) tools).showARecordOfTable(object);

    }

    @Override
    public void deleteRecord(Object object) throws SQLException, IOException {

        Tools tools = new DeleteRecord();
        ((DeleteRecord) tools).deleteRecordFromTable(object);

    }

    @Override
    public void updateRecord(Object object) throws SQLException, IOException {

        Tools tools = new UpdateRecord();
        ((UpdateRecord) tools).updateARecordOfTable(object);

    }

    @Override
    public void showAllRecord(Object object) throws SQLException, IOException {

        Tools tools = new ShowAllRecord();
        ((ShowAllRecord) tools).showAllRecordOfTables(object);
    }

    @Override
    public void createTable(Object object) throws SQLException, IOException {

        Tools tools = new CreateTable();
        ((CreateTable) tools).createTableInDatabase(object);

    }

}