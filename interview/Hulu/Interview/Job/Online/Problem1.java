package interview.Hulu.Interview.Job.Online;

import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] nums = new int[n], dp = new int[100005];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(in.nextLine());
            dp[nums[i]] += nums[i];
        }
        for (int i = 0; i < 100004; i++) dp[i + 1] += dp[i];
        for (int i = 0; i < n; i++) {
            System.out.println(dp[nums[i] - 1]);
        }
    }
}
