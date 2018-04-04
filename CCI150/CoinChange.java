package CCI150;

import java.util.Scanner;

public class CoinChange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            System.out.println(changes(in.nextInt()));
        }
    }

    public static int changes(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) dp[i] = (i < 1 ? 0 : dp[i - 1]) + (i < 5 ? 0 : dp[i - 5]) + (i < 10 ? 0 : dp[i - 10]) + (i < 25 ? 0 : dp[i - 25]);
        for (int num : dp) System.out.print(num + " ");
        System.out.println();
        return dp[n];
    }
}
