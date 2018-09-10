package interview.Hulu.Job.Online;

import java.util.*;

public class Problem4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine()), mod = 1000000007;
        for (int i = 0; i < T; i++) {
            String[] items = in.nextLine().split(" ");
            int n = Integer.parseInt(items[0]), m = Integer.parseInt(items[1]);
            long[] dp = new long[m + 1];
            for (int j = 0; j <= m; j++) {
                dp[j] += j > 0 ? dp[j - 1] : 0;
                dp[j] += j > 1 ? dp[j - 2] : 0;
                dp[j] += j > 2 ? dp[j - 3] : 0;
                dp[j] += j > 3 ? dp[j - 4] : 0;
                dp[j] %= mod;
            }
            long ans = 1;
            for (int j = 0; j < n; j++) {
                ans *= dp[m];
                ans %= mod;
            }
            for (int j = 1; j < m; j++) {
                long tmp = dp[j] * dp[m - j], dup = 1;
                for (int k = 0; k < n; k++) {
                    dup *= tmp;
                    dup %= mod;
                }
                ans -= dup;
                ans %= mod;
            }
            System.out.println(ans);
        }
    }
}
