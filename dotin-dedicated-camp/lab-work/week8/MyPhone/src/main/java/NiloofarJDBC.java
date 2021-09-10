import JDBC.ConnectionDB;
import JDBC.jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NiloofarJDBC implements jdbc {
    Person p=new Person();
    Statement statement;
    PreparedStatement ps=null;

    {
        try {
            statement = ConnectionDB.getConnection().createStatement();
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }

    @Override
    public void save(ArrayList Pl) {
        try {
           ps=ConnectionDB.getConnection().prepareStatement("INSERT INTO PHONE_NIL.persons_phone (Id,LastName,FirstName,Address,PhoneNumber) values (?,?,?,?,?)");
            ps.setString(1,String.valueOf((Pl.get(0))));
            ps.setString(2,String.valueOf(Pl.get(1)));
            ps.setString(3,String.valueOf(Pl.get(2)));
            ps.setString(4,String.valueOf(Pl.get(3)));
            ps.setString(5,String.valueOf(Pl.get(4)));
            ps.executeUpdate();
            System.out.println("done successfully \n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(int id) {
        try {
            ps=ConnectionDB.getConnection().prepareStatement( "update PHONE_NIL.persons_phone set LastName,FirstName,Address,PhoneNumber=?,?,?,? where ID='"+id+"'");
            ps.setString(1,p.getLastName());
            ps.setString(2,p.getFirstName());
            ps.setString(3,p.getAddress());
            ps.setString(4,String.valueOf(p.getPhoneNumber()));
        } catch (SQLException e) {
            System.out.println(" not exist \n");
            e.printStackTrace();
        }
      System.out.println("done successfully  \n");
    }


    @Override
    public List findAll() {

        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("select * from PHONE_NIL.persons_phone");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + "     " +
                    resultSet.getString(2) + "     " +
                    resultSet.getString(3) + "     " +
                    resultSet.getString(4) + "     " +
                    resultSet.getString(5) + "     ");}
       } catch (SQLException e) {
        e.printStackTrace();
        }
        return null;
    }


    @Override
    public Object findById(int id) {

        ResultSet resultSet2 = null;
        try {
            resultSet2 = statement.executeQuery("select * from PHONE_NIL.persons_phone where Id="+ id);
            while (resultSet2.next()) {
                System.out.println(resultSet2.getInt(1) + "     " +
                        resultSet2.getString(2) + "     " +
                        resultSet2.getString(3) + "     " +
                        resultSet2.getString(4) + "     " +
                        resultSet2.getString(5) + "     ");}
        } catch (SQLException e) {
            System.out.println(" not exist \n");
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void deleteP(int id) {
    try {
        ps = ConnectionDB.getConnection().prepareStatement(" delete from PHONE_NIL.persons_phone where Id='" + id + "' ");
        ps.executeUpdate();
        System.out.println("done successfully  \n");
    }catch (SQLException  e){
        System.out.println(" not exist \n");
        e.printStackTrace();
    }
    }
}
