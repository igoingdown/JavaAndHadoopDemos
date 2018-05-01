package CCI150;

public class ChooseMElementsInNArray {
    public static void main(String[] args) {
        int[] nums = {23, 3, 5, 69, 2, 4};
        int[] subset = chooseMElementsInNArray(nums, 2);
        for (int n : subset) System.out.println(n);
    }

    public static int[] chooseMElementsInNArray(int[] nums, int m) {
        int[] subset = new int[m];
        for (int i = 0; i < m; i++) subset[i] = nums[i];
        for (int i = m; i < nums.length; i++) {
            int k = rand(0, i);
            if (k < m) subset[k] = nums[i];
        }
        return subset;
    }

    public static int rand(int low, int high) {
        return low + (int)Math.random() * (high - low + 1);
    }
}
