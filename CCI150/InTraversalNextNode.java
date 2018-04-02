package CCI150;

public class InTraversalNextNode {
    public static void main(String[] args) {

    }
    public static TreeNode nextNode(TreeNode cur) {
        if (cur == null) return null;
        if (cur.right != null) return leftMostNode(cur.right);
        while (cur.parent != null && cur == cur.parent.right) cur = cur.parent;
        return cur.parent;
    }
    public static TreeNode leftMostNode(TreeNode root) {
        while (root != null && root.left != null) root = root.left;
        return root;
    }
}
