package CCI150;

import java.util.LinkedList;


public class PathSumIV {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(10);
        pathSum(root, 6);
    }

    public static void dfs(TreeNode root, int sum) {
        if (sum == root.val) {
            for (int n : path) System.out.print(n + " ");
            System.out.print(sum);
            System.out.println();
        }
        path.addLast(root.val); sum -= root.val;
        if (root.left != null) dfs(root.left, sum);
        if (root.right != null) dfs(root.right, sum);
        path.removeLast();
    }

    public static void pathSum(TreeNode root, int sum) {
        if (root == null) return;
        dfs(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
    }
    private static LinkedList<Integer> path = new LinkedList<>();
}
