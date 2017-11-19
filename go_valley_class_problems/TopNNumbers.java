package go_valley_class_problems;

import java.util.*;

public class TopNNumbers {
    public static void main(String[] args) {
        int[][] nums = {
                {5, 8, 7},
                {2, 9, 5},
                {0, 2, 3}
        };
        int[] res = findElements(nums);
        for (int i : res) System.out.println(i);
    }

    private static int[] findElements(int[][] nums) {
        int m = nums.length;
        if (m == 0) return new int[0];
        int n = nums[0].length;
        if (n == 0) return new int[0];
        List<Integer> a = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i : nums[0]) q.offer(i);
        for (int i = 1; i < m; i++) {
            a.clear(); // 清空上一轮排序后的q的结果, 随后加入本轮的q排序后的结果。
            while (!q.isEmpty()) {
                a.add(q.peek());
                q.poll();
            }
            Arrays.sort(nums[i]);
            for (int j = n - 1; j >= 0; j--) { // 遍历nums[i]
                for (int k = n - 1; k >= 0; k--) {  // 遍历q
                    if (q.size() < n) {
                        q.offer(nums[i][j] + a.get(k));
                    } else {
                        if (nums[i][j] + a.get(k) > q.peek()) {
                            q.poll();
                            q.offer(nums[i][j] + a.get(k));
                        } else break;
                    }
                }
            }
        }
        int[] res = new int[n];
        while (!q.isEmpty()) {
            res[q.size() - 1] = q.peek();
            q.poll();
        }
        return res;
    }
}

