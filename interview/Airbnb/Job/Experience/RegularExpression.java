package interview.Airbnb.Job.Experience;

import java.util.Scanner;

public class RegularExpression {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine(), p = in.nextLine();
            System.out.println(match(s, p));
        }
    }

    private static boolean match(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int j = 2; j <= m; j++) dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == '*') dp[i][j] = j > 1 && (dp[i][j - 2] || ((p.charAt(j - 2) == '.' || s.charAt(i - 1) == p.charAt(j - 2)) && dp[i - 1][j]));
                else if (p.charAt(j - 1) == '+') dp[i][j] = j > 1 && (dp[i][j - 1] || ((p.charAt(j - 2) == '.' || s.charAt(i - 1) == p.charAt(j - 2)) && dp[i - 1][j]));
                else dp[i][j] = dp[i - 1][j - 1] && (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1));
            }
        }
        return dp[n][m];
    }
}
