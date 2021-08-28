import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test2 {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\ASUS\\Desktop\\New Text Document");
        RandomAccessFile accessFile = new RandomAccessFile(file,"rw");
        FileChannel inChannel = accessFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        int bytesRead = inChannel.read(buffer);

        while (bytesRead != -1) {
            System.out.println("Out: " + bytesRead);
            buffer.flip();

            while (buffer.hasRemaining()){
                System.out.println((char) buffer.get());
            }

            buffer.clear();
            bytesRead = inChannel.read(buffer);
        }
        accessFile.close();
    }
}
