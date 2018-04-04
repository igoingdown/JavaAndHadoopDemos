package CCI150;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeagalParenthis {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            for (String s : combinations(in.nextInt())) System.out.print(s + " ");
            System.out.println();
        }
    }

    public static List<String> combinations(int n) {
        StringBuilder buffer = new StringBuilder();
        List<String> res = new ArrayList<>();
        dfs(res, n, n, buffer);
        return res;
    }

    public static void dfs(List<String> res, int left, int right, StringBuilder buffer) {
        if (left < 0 || right < 0) return;
        if (left == 0 && right == 0) {
            res.add(buffer.toString()); return;
        }
        if (left > 0) {
            buffer.append('(');
            dfs(res, left - 1, right, buffer);
            buffer.deleteCharAt(buffer.length() - 1);
        }
        if (left < right) {
            buffer.append(')');
            dfs(res, left, right - 1, buffer);
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }
}
