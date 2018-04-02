package CCI150;

public class SubtreeJudge {
    public static void main(String[] args) {

    }

    public static boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (isSame(root1, root2)) return true;
        return isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
    }

    public static boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        else if (root1 != null && root2 != null) return root1.val == root2.val && isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
        else return false;
    }
}
