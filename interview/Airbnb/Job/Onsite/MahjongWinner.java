package interview.Airbnb.Job.Onsite;

import java.util.Scanner;

public class MahjongWinner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] nums = in.nextLine().split(" ");
            int[] freq = new int[10];
            for (String num : nums) freq[Integer.parseInt(num)]++;
            boolean win = false;
            for (int i = 1; i <= 9; i++) {
                if (freq[i] > 1) {
                    freq[i] -= 2;
                    if (dfs(freq)) {
                        win = true;
                        System.out.println("Win");
                        break;
                    }
                    freq[i] += 2;
                }
            }
            if (!win) System.out.println("Fail");
        }
    }

    private static boolean dfs(int[] freq) {
        int sum = 0;
        for (int num : freq) sum += num;
        if (sum == 0) return true;
        for (int i = 1; i <= 9; i++) {
            if (freq[i] > 2) {
                freq[i] -= 3;
                if (dfs(freq)) return true;
                freq[i] += 3;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (freq[i] > 0 && freq[i + 1] > 0 && freq[i + 2] > 0) {
                freq[i]--;
                freq[i + 1]--;
                freq[i + 2]--;
                if (dfs(freq)) return true;
                freq[i]++;
                freq[i + 1]++;
                freq[i + 2]++;
            }
        }
        return false;
    }

}
