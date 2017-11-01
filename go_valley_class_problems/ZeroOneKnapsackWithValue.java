package go_valley_class_problems;

public class ZeroOneKnapsackWithValue {
    public static void main(String[] args) {
        int[] weights = {1, 3, 4, 5};
        int[] values = {3, 8, 4, 7};
        System.out.println(maxValue(weights, values, 1));
    }

    public static int maxValue(int[] weights, int[] values, int target) {
        int m = weights.length;
        int[][] dp = new int[m + 1][target + 1];
        for (int i = 1; i < m + 1; i++) {
            int itemIndex = i - 1;
            for (int j = 1; j < target + 1; j++) {
                if (weights[itemIndex] <= j) {
                    dp[i][j] = Math.max(values[itemIndex] + dp[i - 1][j - weights[itemIndex]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][target];
    }

}
