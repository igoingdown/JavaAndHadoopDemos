package IntroductionToAlgorithms.Examples;

public class MinMax {
    public static void main(String[] args) {
        int[] nums = {3, 5, 1};
        for (int num : minAndMax(nums)) System.out.println(num);
    }

    private static int[] minAndMax(int[] nums) {
        int[] ans = new int[2];
        int n = nums.length, i;
        if ((n & 1) == 0) {
            i = 2;
            ans[0] = Math.max(nums[0], nums[1]);
            ans[1] = Math.min(nums[0], nums[1]);
        } else {
            i = 1;
            ans[0] = nums[0];
            ans[1] = nums[0];
        }
        int bigger, smaller;
        while (i < n && i + 1< n) {
            if (nums[i] > nums[i + 1]) {
                bigger = nums[i];
                smaller = nums[i + 1];
            } else {
                bigger = nums[i + 1];
                smaller = nums[i];
            }
            ans[0] = Math.max(ans[0], bigger);
            ans[1] = Math.min(ans[1], smaller);
            i += 2;
        }
        return ans;
    }

}
