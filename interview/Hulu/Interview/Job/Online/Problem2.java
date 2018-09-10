package interview.Hulu.Interview.Job.Online;

import java.util.*;
public class Problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ans = 0, n = Integer.parseInt(in.nextLine());
        int[] nums = new int[n];
        for (int i =0; i < n; i++) {
            nums[i] = Integer.parseInt(in.nextLine());
        }
        Arrays.sort(nums);
        if (n >= 3) {
            for(int i = 0; i < n; i++) {
                int j = i;
                while(i != (j + 1) % n && (nums[(j + 1) % n] - nums[i] + 36000) % 36000 < 18000) j++;
                ans += j != i ? (j - i - 1) * (j - i) / 2 : 0;
            }
        }
        System.out.println(ans);
    }
}
