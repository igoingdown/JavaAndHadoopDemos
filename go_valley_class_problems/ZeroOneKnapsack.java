package go_valley_class_problems;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int[] weights = {1, 2, 4, 6, 8};
        if (knapsack(10, weights, 0)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    public static boolean knapsack(int target, int[] weights, int i) {
        if (target == 0) {
            return true;
        }
        if (target < 0 || i == weights.length) {
            return false;
        }
        return knapsack(target - weights[i], weights, i + 1) || knapsack(target, weights, i + 1);
    }

}



