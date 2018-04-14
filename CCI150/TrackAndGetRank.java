package CCI150;

import java.util.*;

public class TrackAndGetRank {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int cur = in.nextInt();
            track(cur);
            System.out.println(getRank(cur));
        }
    }

    public static class RankNode {
        int val, left_count = 0;
        RankNode left = null, right = null;
        public RankNode(int x) {
            val = x;
        }
    }

    private static RankNode root = null;

    public static void track(int x) {
        if (root == null) root = new RankNode(x);
        else insert(root, x);
    }

    public static void insert(RankNode root, int x) {
        if (root.val >= x) {
            root.left_count++;
            if (root.left == null) root.left = new RankNode(x);
            else insert(root.left, x);
        } else {
            if (root.right == null) root.right = new RankNode(x);
            else insert(root.right, x);
        }
    }

    public static int getRank(int x) {
        return getRank(root, x) - 1;
    }

    public static int getRank(RankNode root, int x) {
        if (root == null) return 0;
        if (root.val <= x) return root.left_count + 1 + getRank(root.right, x);
        else return getRank(root.left, x);
    }
}
