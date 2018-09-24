package interview.Airbnb.Job.Experience;

import java.util.*;

public class CollatzConjecture {
    private static Map<Integer, Integer> memo = new HashMap<>();
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            System.out.println(findLongestSteps(n));
        }
    }

    private static int findLongestSteps(int n) {
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            int steps = findSteps(i);
            ans = Math.max(ans, steps);
        }
        return ans;
    }

    private static int findSteps(int n) {
        if (memo.containsKey(n)) return memo.get(n);
        int ans = 1;
        if (n > 1 && (n & 1) == 0) {
            ans = 1 + findSteps(n / 2);
        } else if (n > 1 && (n & 1) == 1) {
            ans = 1 + findSteps(n * 3 + 1);
        }
        memo.put(n, ans);
        return ans;
    }
}
