package go_valley_class_problems;

import java.util.*;


public class Permutation {
    public static void  main(String[] args) {
        int[] nums = {0, 1, 2, 3};
        for (List<Integer> permutation: permute(nums)) {
            for (Integer n : permutation) {
                System.out.print(n);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(num);
        permute(results, num, 0);
        return results;
    }

    public static void permute(List<List<Integer>> results, int[] num, int index) {
        if (index == num.length) {
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < num.length; i++) result.add(num[i]);
            results.add(result);
            return;
        }
        for (int i = index; i < num.length; i++) {
            swap(num, index, i);
            permute(results, num, index + 1);
            swap(num, index, i);
        }
    }

    public static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
