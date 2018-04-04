package CCI150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        int[] set = {1, 2, 3};
        for (List<Integer> list : subsets(set)) {
            for (int n : list) System.out.print(n + " ");
            System.out.println();
        }
        System.out.println();
        for (List<Integer> subset : subsetsBasedOnMath(set)) {
            for (int num : subset) System.out.print(num + " ");
            System.out.println();
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        res.add(new LinkedList<>());
        for (int num : nums) {
            int n = res.size();
            for (int i = 0; i < n; i++) {
                List<Integer> tmp = new LinkedList<>(res.get(i));
                tmp.add(num); res.add(tmp);
            }
        }
        return res;
    }

    public static List<List<Integer>> subsetsBasedOnMath(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        long max = 1 << (nums.length);
        for (int i = 0; i < max; i++) {
            changeNumToSet(nums, res, i);
        }
        return res;
    }

    public static void changeNumToSet(int[] nums, List<List<Integer>> res, int num) {
        List<Integer> subset = new ArrayList<>();
        int index = 0;
        while (num > 0) {
            if ((num & 1) == 1) subset.add(nums[index]);
            num >>= 1; ++index;
        }
        res.add(subset);
    }
}
