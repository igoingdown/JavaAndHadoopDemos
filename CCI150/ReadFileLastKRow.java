package CCI150;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadFileLastKRow {
    public static void main(String[] args) {
        printLastKRow("/Users/zhaomingxing/IdeaProjects/hello_world/src/file.txt", 3);
    }

    public static void printLastKRow(String filePath, int k) {
        String[] lastKLines = new String[k];
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath)), "UTF-8"));
        } catch (Exception e) {
            System.out.println(e.toString());
            return;
        }
        String line = null;
        int index = 0;
        while (true) {
            try {
                line = reader.readLine();
            } catch (Exception e) {
                System.out.println(e.toString());
                return;
            }
            if (line != null) {
                lastKLines[index] = line;
                index = (index + 1) % k;
            } else {
                for (int i = 0; i < k; i++) System.out.println(lastKLines[(index + i) % k]);
                return;
            }
        }
    }
}
