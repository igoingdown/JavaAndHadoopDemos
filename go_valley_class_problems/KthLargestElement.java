package go_valley_class_problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(findElement(nums, 4));
    }

    static int findElement(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            if (i < k) q.offer(nums[i]);
            else {
                if (nums[i] > q.peek()) {
                    q.poll();
                    q.offer(nums[i]);
                }
            }
        }
        return q.peek();
    }
}
