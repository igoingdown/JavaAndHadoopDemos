package package_1;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by zhaomingxing on 2017/1/6.
 */
public class NioTest {
    public static void main(String[] args) {
        try{
            RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/zhaomingxing/IdeaProjects/hello_world/src/java_basic_tools/nio_test_file.txt", "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(512);
            try {
                int bytesRead = fileChannel.read(buffer);
                if (bytesRead == -1) {
                    return;
                }
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.print((char)buffer.get());
                }
                buffer.clear();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
