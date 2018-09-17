package interview.ByteDance.Job.Online.Round2;

import java.util.*;

public class Problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt(), modNum = 1000000007;
            long[] dp = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                long mul = 1;
                for (int j = 0; j < i; j++) {
                    mul *= 10;
                    mul %= modNum;
                }
                dp[i] += mul;
                dp[i] %= modNum;
                for (int j = 0; j < i; j++) {
                    dp[i] += dp[j] * dp[i - j - 1] % modNum * 2 %modNum;
                    dp[i] %= modNum;
                }
                dp[i] += i > 1 ? dp[i - 2] : 0;
                dp[i] %= modNum;
            }
            System.out.println(dp[n]);
        }
    }
}
