import java.io.*;

public class Test {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\ASUS\\Desktop\\New Text Document");
        OutputStream outputStream = new FileOutputStream(file);
        Writer opw = new OutputStreamWriter(outputStream);
        opw.write("hellloooo");
        opw.close();
    }
//        if (file.exists()) {
//            System.out.println("yay! file exist.");
//            FileInputStream fileInputStream = new FileInputStream(file);
//            byte[] db = new byte[1024];
//            int data = fileInputStream.read(db,0,db.length);
//            while (data != -1) {
//                data = fileInputStream.read(db,0,db.length);
//            }
//            fileInputStream.close();
//        }
//    }
}
