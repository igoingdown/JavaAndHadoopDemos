package go_valley_class_problems;

import java.lang.*;

public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 4, 2}, {3, 5, 42, 3}, {2, 1, 2, 3}, {2, 2, 4, 2}};
        System.out.println(minimumPathSum2D(grid));
        System.out.println(minimumPathSum1D(grid));

    }

    public static int minimumPathSum2D(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1 ; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] += grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n -1];
    }

    public static int minimumPathSum1D(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[m];
        dp[0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i] = grid[i][0] + dp[i - 1];
        }
        for (int j = 1; j < n; j++) {
            dp[0] += grid[0][j];
            for (int i = 1; i < m; i++) {
                dp[i] = Math.min(dp[i], dp[i - 1]) + grid[i][j];
            }
        }
        return dp[m - 1];
    }

}
