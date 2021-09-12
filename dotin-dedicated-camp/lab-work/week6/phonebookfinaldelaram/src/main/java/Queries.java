import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Queries{
    String q="";
    List<Person> persons=new ArrayList<Person>();
    ConnectToDB connectToDB=new ConnectToDB();


    Statement statement;

    {
        try {
            statement = connectToDB.setValue().createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void insert(Person p) throws SQLException {
        this.q="insert into tblperson" +
                "values("+p.getId()+","+p.getName()+","+p.getFamily()+","+p.getPhonenum()+")";
        statement.executeQuery(q);
    }
    public void delete(int id) throws SQLException {
        this.q="delete tblperson where id="+id;
        statement.executeQuery(q);
    }
    public List<Person> select(List<Integer> id) throws SQLException {
        this.q="select * from tblperson where id in("+id+")";
        statement.executeQuery(q);
        ResultSet resultSet=statement.executeQuery(q);

        return (List<Person>) resultSet;
    }
    public void update(Person p) throws SQLException {
        this.q="update tblperson set name="+p.getName()+"where id="+p.getId()+"\n"+
                "update tblperson set family="+p.getFamily()+"where id="+p.getId()+"\n"+
                "update tblperson set phonenum="+p.getFamily()+"where id="+p.getId();
        statement.executeQuery(q);
    }
}
