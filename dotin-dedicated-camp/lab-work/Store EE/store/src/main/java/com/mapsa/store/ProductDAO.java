package com.mapsa.store;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public ProductDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
    protected void connect() throws SQLException{
        if(jdbcConnection==null || jdbcConnection.isClosed()){
          try{
              Class.forName("com.mysql.jdbc.Driver");
          }catch (ClassNotFoundException e){
              throw new SQLException(e);
          }
            jdbcConnection= DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        }
   }

    protected void disconnect() throws SQLException{

     if(jdbcConnection!=null && !jdbcConnection.isClosed()){
         jdbcConnection.close();
     }
    }

          public boolean insertProduct(Product product)throws SQLException{
           String sql="INSERT INTO SHOP.product (name, description, price) VALUES(?,?,?)";
              connect();
                  PreparedStatement statement=jdbcConnection.prepareStatement(sql);
                  statement.setString(1,product.getNameP());
                  statement.setString(2,product.getDescription());
                  statement.setFloat(3,product.getPrice());

              Boolean rowInserted=statement.executeUpdate()>0;
              statement.close();
              disconnect();
              return rowInserted;
     }


          public List<Product> listAllProduct() throws SQLException{
            List<Product> listProduct=new ArrayList<>();
          String sql="SELECT * FROM SHOP.product";
            connect();
              Statement statement=jdbcConnection.createStatement();
              ResultSet resultSet=statement.executeQuery(sql);
             while (resultSet.next()){
                int id=resultSet.getInt("product_id");
                String nameP=resultSet.getString("name");
                String description=resultSet.getString("description");
                float price=resultSet.getFloat("price");
               Product product=new Product(id,nameP,description,price);
               listProduct.add(product);

             }
              resultSet.close();
              statement.close();
              disconnect();
             return listProduct;
     }


       public boolean deleteProduct(Product product)throws SQLException{
           String sql="DELETE FROM SHOP.product where product_id = ?";
           connect();
           PreparedStatement statement=jdbcConnection.prepareStatement(sql);
           statement.setInt(1,product.getId());
           boolean rowDeleted=statement.executeUpdate() > 0;
           statement.close();
            disconnect();
         return rowDeleted;
       }

    public boolean updateProduct(Product product)throws SQLException{
        String sql="UPDATE SHOP.product set name= ?,description= ?,price= ?";
        sql +="WHERE product_id = ? ";
        connect();
        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
        statement.setString(1,product.getNameP());
        statement.setString(2,product.getDescription());
        statement.setFloat(3,product.getPrice());
        statement.setInt(4,product.getId());
    boolean rowUpdated=statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowUpdated;
    }

    public Product getProduct(int id)throws SQLException{
         Product product=null;
         String sql="SELECT * FROM SHOP.product WHERE product_id = ?";
         connect();
         PreparedStatement statement=jdbcConnection.prepareStatement(sql);
         statement.setInt(1,id);
          ResultSet resultSet=statement.executeQuery();
          if(resultSet.next()){
              String nameP=resultSet.getString("name");
              String description=resultSet.getString("description");
              float price=resultSet.getFloat("price");
              product=new Product(id,nameP,description,price);
          }
          resultSet.close();
           disconnect();
          return product;
    }


}
