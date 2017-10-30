package java_basic_tools;

import java.io.FileWriter;

/**
 * Created by zhaomingxing on 2017/6/26.
 */
public class TestFileWriter {
    public static void main(String[] args) {
        try {
            FileWriter aWriter = new FileWriter("./re.txt", true);
            aWriter.write("aa");
            aWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
