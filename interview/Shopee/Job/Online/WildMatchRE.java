package interview.Shopee.Job.Online;

import java.util.*;

public class WildMatchRE {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // ? # *, 1次，0次或1次，0次或多次
        while (in.hasNext()) {
            String pattern = in.nextLine(), str = in.nextLine();
            int n = pattern.length(), m = str.length();
            boolean[][] dp = new boolean[n + 1][m + 1];
            for (int i = 0; i < n; i++) dp[i] = new boolean[m + 1];
            dp[0][0] = true;
            for (int i = 1; i <= n; i++) dp[i][0] = dp[i - 1][0] && (pattern.charAt(i - 1) == '#' || pattern.charAt(i - 1) == '*');
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (pattern.charAt(i - 1) == '?') dp[i][j] = dp[i - 1][j - 1];
                    else if (pattern.charAt(i - 1) == '#') dp[i][j] = dp[i - 1][j - 1] || dp[i - 1][j];
                    else if (pattern.charAt(i - 1) == '*') dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    else dp[i][j] = dp[i - 1][j - 1] && pattern.charAt(i - 1) == str.charAt(j - 1);
                }
            }
            System.out.println(dp[n][m] ? 1 : 0);
        }

    }
}
