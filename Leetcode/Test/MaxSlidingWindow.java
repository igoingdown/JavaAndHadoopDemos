package Leetcode.Test;

import java.util.*;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] arr = {1,3,1,2,0,5};
        for (int num : maxSlidingWindow(arr, 3)) System.out.println(num);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return new int[0];
        int[] res = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && nums[q.getLast()] < nums[i]) q.removeLast();
            q.addLast(i);
            if (i >= k + q.getFirst()) q.removeFirst();
            if (i >= k - 1) res[i - k + 1] = nums[q.getFirst()];
        }
        return res;
    }
}
