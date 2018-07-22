package interview.pinduoduo;

import java.util.Scanner;

public class Online2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            System.out.println(shortestSubstring(s));
        }
    }

    private static String shortestSubstring(String s) {
        for (int i = 1; i <= s.length(); i++) {
            String p = s.substring(0, i);
            int j = 0;
            while (j < s.length() && s.charAt(j) == p.charAt(j % p.length())) j++;
            if (j == s.length()) return p;
        }
        return s;
    }
}
