package go_valley_class_problems;

import java.util.ArrayList;
import java.util.List;

public class MaximumGap {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 5, 5, 5, 5};
        System.out.println(maximumGap(nums));
    }

    private static int maximumGap(int[] nums) {
        int maxElem = Integer.MIN_VALUE, minElem = Integer.MAX_VALUE, l = nums.length, res = 0;
        if (l == 0) return res;
        for (int n : nums) {
            maxElem = Math.max(maxElem, n);
            minElem = Math.min(minElem, n);
        }
        // if (maxElem == minElem) return res;
        int bucketSize = (maxElem - minElem) / l + 1;
        // l 就是桶的个数，n个数字n个桶，极限状态下每个桶只有一个数字，
        //     非极限状态的话，至少有一个桶为空（鸽巢原理）。
        //     因此有结论：最大的Gap一定出现在桶之间。
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= l; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int n : nums) {
            int bucketID = (n - minElem) / bucketSize;
            if (buckets.get(bucketID).size() == 0) {
                buckets.get(bucketID).add(n);
                buckets.get(bucketID).add(n);
            } else {
                buckets.get(bucketID).set(0, Math.min(buckets.get(bucketID).get(0), n));
                buckets.get(bucketID).set(1, Math.max(buckets.get(bucketID).get(1), n));
            }
        }
        int pre = 0;
        for (int i = 1; i < l + 1; i++) {
            if (buckets.get(i).size() == 0) continue;
            res = Math.max(res, buckets.get(i).get(0) - buckets.get(pre).get(1));
            pre = i;
        }
        return res;
    }
}
