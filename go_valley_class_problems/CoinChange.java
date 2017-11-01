package go_valley_class_problems;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {3, 5};
        System.out.println(solutionDP(coins, 19));
    }

    public static int solutionDP(int[] coins, int amount) {
        int m = coins.length;
        int[][] dp = new int[m][amount + 1];
        for (int i = 0; i < amount + 1; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = i / coins[0];
            } else {
                dp[0][i] = -1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j < coins[i]) dp[i][j] = dp[i - 1][j];
                else {
                    int tmp = Integer.MAX_VALUE;
                    for (int k = 0; k <= j / coins[i]; k++) {
                        int remain = j - coins[i] * k;
                        if (dp[i - 1][remain] != -1) {
                            tmp = Math.min(tmp, dp[i - 1][remain] + k);
                        }
                    }
                    dp[i][j] = (tmp == Integer.MAX_VALUE ? -1 : tmp);
                }
            }
        }

        return dp[m -1][amount];
    }
}
