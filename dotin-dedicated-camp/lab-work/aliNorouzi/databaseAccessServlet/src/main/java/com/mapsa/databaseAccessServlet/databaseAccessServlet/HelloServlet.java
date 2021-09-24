package com.mapsa.databaseAccessServlet.databaseAccessServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.postgresql.jdbc.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/mapsa";

    // Database credentials
    static final String USERNAME = "postgres";
    static final String Password = "admin";
    static Connection connection;
    static Statement statement;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        String title = "Using Get Method toRead Form Data";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 5.0" + "transitional//en\">\n";
        out.println(docType +
                "<html> \n" +
                "<head> <title>" + title + "</title></title>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<form action=\"hello-servlet\" method=\"post\">\n" +
                "    First Name: <input type=\"text\" name=\"first_name\">\n" +
                "    <br />\n" +
                "    Last Name:  <input type = \"text\" name=\"last_name\">\n" +
                "    Age:  <input type = \"number\" name=\"age\">\n" +
                "    <input type=\"submit\" value=\"Submit\" />\n" +
                "</form>" +
                "</body>" +
                "</html>");

        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        int age = Integer.parseInt(request.getParameter("age"));

        try {
            // Register JDBC driver
            Class.forName("org.postgresql.Driver");

            // Open a connection
            connection = DriverManager.getConnection(DB_URL,USERNAME,Password);

            // Execute SQL query
            statement = connection.createStatement();
            String sql;
            sql = "select * from \"Employee\"";
            String sql2 = " insert into \"Employee\" (id, age, first_name, last_name) values (" +
                    System.currentTimeMillis() + "," +
                    age + "," +
                    "\'" +first_name + "\'" + "," +
                    "\'" + last_name + "\'" + ")";
            statement.executeQuery(sql2);
            ResultSet rs = statement.executeQuery(sql);

            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");
                int ageResult = rs.getInt("age");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                // Display values
                out.println("ID: " + id + "<br>");
                out.println(", Age: " + ageResult + "<br>");
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

/**
 * redirecting to a specific address


         // Where to redirect
        String address = "http://localhost:8080/databaseAccessServlet_war_exploded/DatabaseAccess";

        // Redirecting
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", address);
*/
        // redirecting to another servlet and jsp page
        response.sendRedirect("redirectedHelloServlet.jsp?first_name="+first_name+"&last_name="+last_name+"&age="+age);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request, response);
    }

    public void destroy() {
    }
}