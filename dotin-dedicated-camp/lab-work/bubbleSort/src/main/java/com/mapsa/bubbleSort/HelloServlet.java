package com.mapsa.bubbleSort;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private int arrayLength;
    private int[] array;


    public void init() {
        message = "Please enter your numbers: ";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        arrayLength = Integer.parseInt(request.getParameter("arrayLength"));
        array = new int[arrayLength];
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<form method=\"post\" action=\"hello-servlet\">");
        for (int i = 0; i < arrayLength; i++) {
            out.println((i+1)+")  " + "<input type=\"number\" name=\"number" + (i + 1) + "\"><br/>");
        }
        out.println("<button type=\"submit\" value=\"submit\">Submit</button> <br/>" +
                "</form>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        for (int i = 0; i < arrayLength; i++) {
            array[i] = Integer.parseInt(request.getParameter("number" + (i + 1)));
        }
        int temp = 0;
        for (int first = 0; first < array.length; first++) {
            for (int second = 0; second < array.length; second++) {
                if (array[first] < array[second]) {
                    temp = array[first];
                    array[first] = array[second];
                    array[second] = temp;
                }
            }
        }
        PrintWriter out = response.getWriter();
        out.println("<h1>Sorted List:</h1><br/>");
        String sorted = "";
        for (int i = 0; i<array.length; i++){
            sorted += array[i] + ", ";
        }
        sorted = sorted.substring(0, sorted.length()-2);
        out.println("{" + sorted +"}");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}