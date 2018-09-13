package interview.VMware.Job.Online;

import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] nAndW = in.nextLine().split(" ");
        int N = Integer.parseInt(nAndW[0]), W = Integer.parseInt(nAndW[1]);
        int[] nums = new int[N], workers = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(in.nextLine());
        }
        Arrays.fill(workers, W);
        Arrays.sort(nums);
        for (int i = N - 1; i >= 0; i--) {
            Arrays.sort(workers);
            int index = lowerBound(workers, nums[i]);
            if (index != -1) {
                workers[index] -= nums[i];
            }
        }
        Arrays.sort(workers);
        int ans = 0;
        while (workers[ans] != W) ans++;
        System.out.println(ans);
    }

    private static int lowerBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] < target) low = mid + 1;
            else high = mid;
        }
        if (low > 0 && low < nums.length && nums[low] >= target) return low;
        else return -1;
    }
}
