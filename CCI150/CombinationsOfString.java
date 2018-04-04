package CCI150;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombinationsOfString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            for (String s : combines(str)) System.out.print(s + " ");
            System.out.println();
        }
    }
    public static List<String> combines(String str) {
        StringBuilder buffer = new StringBuilder();
        int[] map = new int[256];
        for (int i = 0; i < str.length(); i++) map[str.charAt(i)]++;
        List<String> res = new ArrayList<>();
        dfs(res, str, buffer, map);
        return res;
    }

    public static void dfs(List<String> res, String str, StringBuilder buffer, int[] map) {
        if (buffer.length() == str.length()) {
            res.add(buffer.toString()); return;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                buffer.append((char)i); --map[i];
                dfs(res, str, buffer, map);
                buffer.deleteCharAt(buffer.length() - 1); ++map[i];
            }
        }
    }
}
