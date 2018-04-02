package CCI150;

public class BSTJudge {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(10);
        if (isBST(root)) System.out.println("Y");
        else System.out.println("N");
    }

    public static boolean isBST(TreeNode root) {
        TreeNode pre = null;
        return isBST(root, pre);
    }

    public static boolean isBST(TreeNode cur, TreeNode pre) {
        if (cur == null) return true;
        if (!isBST(cur.left, pre)) return false;
        if (pre != null && pre.val > cur.val) return false;
        pre = cur;
        if (!isBST(cur.right, pre)) return false;
        return true;
    }
}
