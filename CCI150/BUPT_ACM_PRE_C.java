package CCI150;

import java.util.Scanner;

public class BUPT_ACM_PRE_C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = 0;
        if (in.hasNext()) t = Integer.parseInt(in.nextLine());
        while (t > 0) {
            String s = in.nextLine();
            System.out.println(count(s));
            --t;
        }
    }

    public static int count(String s) {
        int[] dp = {0, 0, 0, 0};
        //          b  u  p  t
        if (s.length() == 0) return 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == 'b') dp[0] += dp[1];
            else if (s.charAt(i) == 'u') dp[1] += dp[2];
            else if (s.charAt(i) == 'p') dp[2] += dp[3];
            else if (s.charAt(i) == 't') ++dp[3];
            for (int j = 0; j < 4; j++) dp[j] %= 1000000007;
        }
        return dp[0];
    }
}
