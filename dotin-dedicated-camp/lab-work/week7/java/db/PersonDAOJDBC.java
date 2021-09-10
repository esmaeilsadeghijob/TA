package com.mapsa.Mybook.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDAOJDBC implements PerInterface{

    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    Connection connection = null;

    PersonDAOJDBC(){}
    private Connection getConnection() throws IOException, SQLException {
        connection = DBconnection.getInstance().getConnection();
        return connection;
    }


    @Override
    public void add(Person person) throws IOException, SQLException {
        try {
            String queryString = "INSERT INTO person(RollNo, Name, Course, Address) VALUES(?,?,?,?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, person.getId());
            ptmt.setString(2, person.getName());
            ptmt.setString(3, person.getLastName());
            ptmt.setLong(4, person.getPhoneNumber());
            ptmt.executeUpdate();
            System.out.println("Data Added Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void delete(int id) {
        try {
            String queryString = "DELETE FROM person WHERE Id=?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, id);
            ptmt.executeUpdate();
            System.out.println("Data deleted Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void update(Person person) {

        try {
            String queryString = "UPDATE person SET Name=? WHERE Id=?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, person.getName());
            ptmt.setInt(2, person.getId());
            ptmt.executeUpdate();
            System.out.println("Table Updated Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    @Override
    public void showAll() {
        try {
            String queryString = "SELECT * FROM person";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                System.out.println("Peron Id:" + resultSet.getInt("id")
                        + ", Name: " + resultSet.getString("Name") + ", Family: "
                        + resultSet.getString("LastName")+ ", Occupation: "
                        + resultSet.getString("Occupation")
                        + ", PhoneNo:" + resultSet.getLong("PhoneNumber"));
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
