package go_valley_class_problems;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int[] p = {2, 4, 5, 4};
        System.out.println(matrixChain(p));
    }

    public static int matrixChain(int[] p) {
        int n = p.length;
        int[][] dp = new int[n][n];
        for (int i = 1; i < n - 1; i++) {
            dp[i][i + 1] = p[i - 1] * p[i] * p[i + 1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = i + 2; j < n; j++) {
                for (int k = i; k < j; k++) {
                    int tmp = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    dp[i][j] = (dp[i][j] == 0 ? tmp : Math.min(dp[i][j], tmp));
                }
            }
        }
        return dp[1][n - 1];
    }
}
