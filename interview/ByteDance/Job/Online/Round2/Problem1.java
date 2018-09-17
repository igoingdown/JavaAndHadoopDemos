package interview.ByteDance.Job.Online.Round2;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int groups = n;
        int[] parents = new int[n + 1];
        for (int i = 0; i <= n; i++) parents[i] = i;
        for (int i = 1; i <= n; i++) {
            String[] friends = in.nextLine().split(" ");
            for (int j = 0; j < friends.length; j++) {
                int friendIndex = Integer.parseInt(friends[j]);
                if (friendIndex == 0) break;
                int parentI = findParent(i, parents);
                int parentJ = findParent(friendIndex, parents);
                if (parentI != parentJ) {
                    parents[parentJ] = parentI;
                    groups--;
                }
            }
        }
        System.out.println(groups);
    }

    public static int findParent(int x, int[] parents) {
        while (x != parents[x]) {
            parents[x] = parents[parents[x]];
            x = parents[x];
        }
        return x;
    }
}
