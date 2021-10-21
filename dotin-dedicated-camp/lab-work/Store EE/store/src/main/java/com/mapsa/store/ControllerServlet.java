package com.mapsa.store;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ControllerServlet extends HttpServlet {

    private ProductDAO productDAO;

    public void init(){
        String jdbcURL=getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername=getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
       productDAO=new ProductDAO(jdbcURL,jdbcUsername,jdbcPassword);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
              String action=req.getServletPath();
              try {
                  switch (action){
                      case "/new":
                          showNewForm(req,resp);
                         break;
                      case "/insert":
                          insertProduct(req,resp);
                          break;
                      case "/delete":
                          deleteProduct(req,resp);
                          break;
                      case "/edit":
                          showEditForm(req,resp);
                          break;
                      case "/update":
                          updateProduct(req,resp);
                          break;
                      default:
                          listProduct(req,resp);
                          break;
                  }
              } catch (Exception ex) {
                  throw new ServletException(ex);
              }
    }

    public void listProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException,ServletException,IOException{
           List<Product> listProduct=productDAO.listAllProduct();
             req.setAttribute("listProduct",listProduct);
          RequestDispatcher dispatcher=req.getRequestDispatcher("ProductList.jsp");
          dispatcher.forward(req,resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("ProductForm.jsp");
        dispatcher.forward(req, resp);
    }


    private void showEditForm(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product existingProduct = productDAO.getProduct(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("ProductForm.jsp");
        req.setAttribute("product", existingProduct);
        dispatcher.forward(req, resp);
    }


    private void insertProduct(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException {
        String nameP = req.getParameter("nameP");
        String description = req.getParameter("description");
        float price = Float.parseFloat(req.getParameter("price"));
        Product newProduct = new Product(nameP, description, price);
        productDAO.insertProduct(newProduct);
        resp.sendRedirect("list");
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String nameP = req.getParameter("nameP");
        String description = req.getParameter("description");
        float price = Float.parseFloat(req.getParameter("price"));
        Product product = new Product(id, nameP, description, price);
        productDAO.updateProduct(product);
        resp.sendRedirect("list");
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = new Product(id);
        productDAO.deleteProduct(product);
        resp.sendRedirect("list");
    }

}
