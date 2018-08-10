package Leetcode.Test;

import java.util.LinkedList;
import java.util.List;

public class CombinationSum3 {
    public static void main(String[] args) {
        for (List<Integer> list : combinations(3, 15)) {
            for (int num : list) System.out.print(num + "\t");
            System.out.println();
        }
    }

    public static List<List<Integer>> combinations(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        dfs(res, path, k, n, 1);
        return res;
    }

    public static void dfs(List<List<Integer>> res, List<Integer> path, int k, int target, int start) {
        if (path.size() == k && target == 0) res.add(new LinkedList<>(path));
        if (path.size() > k || target < 0 || start > 9) return;
        if (path.size() == k && target > 0) return;
        for (int i = start; i <= 9; i++) {
            path.add(i);
            dfs(res, path, k, target - i, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
