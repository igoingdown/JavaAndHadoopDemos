package CCI150;

public class MagicIndex {
    public static void main(String[] args) {
        int[] arr = {-1, 2, 3, 5};
        System.out.println(magicIndex(arr));
        int[] nums = {-1, -1, 3, 3};
        System.out.println(magicIndexDuplicate(nums));
    }

    public static int magicIndex(int[] nums) {
        if (nums.length == 0) return -1;
        int low = 0, high = nums.length - 1, mid;
        while (low < high) {
            mid = low + ((high - low) >> 1);
            if (nums[mid] < mid) low = mid + 1;
            else high = mid;
        }
        return nums[low] == low ? low : -1;
    }

    public static int magicIndexDuplicate(int[] nums) {
        if (nums.length == 0) return -1;
        return magicIndex(nums, 0, nums.length -1);
    }

    public static int magicIndex(int[] nums, int low, int high) {
        if (low < 0 || low > high || high >= nums.length) return -1;
        if (low == high) return nums[low] == low ? low : -1;
        int mid = low + ((high - low) >> 1);
        if (nums[mid] == mid) return mid;
        int left = magicIndex(nums, low, Math.min(mid - 1, nums[mid]));
        if (left > -1) return left;
        int right = magicIndex(nums, Math.max(mid + 1, nums[mid]), high);
        if (right > -1) return right;
        return -1;
    }
}
