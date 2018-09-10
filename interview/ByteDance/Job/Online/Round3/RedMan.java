package interview.ByteDance.Job.Online.Round3;

import java.util.*;

public class RedMan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine()), m = Integer.parseInt(in.nextLine());
        String[] strings = in.nextLine().split(" ");
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) nums[i] = new int[n];
        for (int i  = 0; i < m; i++) {
            int a = Integer.parseInt(strings[i * 2]);
            int b = Integer.parseInt(strings[i * 2 + 1]);
            nums[a - 1][b - 1] = 1;
        }
        int[][] transition = new int[n][n];
        for (int i = 0; i < n; i++) transition[i] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transition[i][j] = i == j ? 1 : nums[i][j];
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    transition[i][j] = (transition[i][j] | (transition[i][k] & transition[k][j]));
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (j < n && transition[i][j] == 1) j++;
            ans += j == n ? 1 : 0;
        }
        System.out.println(ans);
    }
}
