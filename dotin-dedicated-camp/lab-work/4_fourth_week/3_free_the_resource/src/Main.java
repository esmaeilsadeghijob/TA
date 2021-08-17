import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("File.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        try {
            bufferedWriter.write("Test ");
        }catch (IOException ex){
            ex.printStackTrace();
        }finally {
            bufferedWriter.close();
        }
    }
}
