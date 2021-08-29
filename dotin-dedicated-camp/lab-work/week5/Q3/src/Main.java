import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Byte> list = new ArrayList<>();
        FileInputStream inf= null;
        try{
            inf = new FileInputStream("test.txt");
            int bCode;
            while(-1 != (bCode=inf.read()) )
                list.add((byte)bCode);
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(inf!=null)
                inf.close();
        }
    }
}
