import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class Tamrin_class {
        public static void main(String[] args) throws IOException {
            File file = new File("C://Users/neloufar/Desktop/n1.txt");
            RandomAccessFile accessFile = new RandomAccessFile(file,"rw");
            FileChannel inChannel = accessFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(48);
            int bytesRead = inChannel.read(buf);

            while (bytesRead != -1){
                System.out.println("Out: " + bytesRead);
                buf.flip();

                while (buf.hasRemaining()){
                    System.out.println((char) buf.get());
                }

                buf.clear();
                bytesRead = inChannel.read(buf);
            }
            accessFile.close();
        }
    }

