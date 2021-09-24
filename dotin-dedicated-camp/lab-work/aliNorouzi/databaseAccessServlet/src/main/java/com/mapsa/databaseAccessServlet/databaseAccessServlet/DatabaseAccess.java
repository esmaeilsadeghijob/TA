package com.mapsa.databaseAccessServlet.databaseAccessServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class DatabaseAccess extends HttpServlet {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.postgresql.jdbc.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/mapsa";

    // Database credentials
    static final String USERNAME = "postgres";
    static final String Password = "admin";
    static Connection connection;
    static Statement statement;



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Result";

        String docType =
                "<!doctype html public \"-//w3c//dtd html 5.0" + "transitional//en\">\n";
        out.println(docType +
                "<html> \n" +
                "<head> <title>" + title + "</title></title>\n" +
                "<body bgcocor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n");
        try {
            // Register JDBC driver
            Class.forName("org.postgresql.Driver");

            // Open a connection
            connection = DriverManager.getConnection(DB_URL,USERNAME,Password);

            // Execute SQL query
            statement = connection.createStatement();
            String sql;
            sql = "select * from \"Employee\"";
            ResultSet rs = statement.executeQuery(sql);

            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                long id = rs.getLong("id");
                int age = rs.getInt("age");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                // Display values
                out.println("ID: " + id + "<br>");
                out.println(", Age: " + age + "<br>");
                out.println(", First Name: " + firstName + "<br>");
                out.println(", Last Name: " + lastName + "<br>");
            }
            out.println("</body></html>");

            //Clean-up environment
            rs.close();
            statement.close();
            connection.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se2) {} // nothing we can do
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
    }
}
