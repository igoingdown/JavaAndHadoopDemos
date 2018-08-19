package interview.xiaomi.internship.onsite;

public class Problem1 {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 2, 3};
        System.out.println(missingNum(arr));
    }

    public static int missingNum(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] <= n && nums[i] > 0 && i != nums[i] - 1 && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }
        int res = 1;
        while (res <= n && nums[res - 1] == res) res++;
        return res;
    }
}
