package go_valley_class_problems;

public class LongestIncreasingSequence {
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 5, 7, 6, 8, 2};
        System.out.println(lis(nums));
    }

    private static int lis(int[] nums) {
        int localMax = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[j] < nums[i] || i == j) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    localMax = Math.max(dp[i], localMax);
                }
            }
        }
        return localMax;
    }
}
