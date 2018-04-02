package CCI150;

public class FirstCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(10);
        TreeNode node = lowerestCommonAncestorHelper(root.left.right, root.left.right, root).node;
        if (node != null) System.out.println(node.val);
        else System.out.println("null");
    }

    public static TreeNode firstCommonAncestorOfBST(TreeNode node1, TreeNode node2, TreeNode root) {
        if (root == null) return null;
        if (node1.val < root.val && node2.val < root.val) return firstCommonAncestorOfBST(node1, node2, root.left);
        if (node1.val > root.val && node2.val > root.val) return firstCommonAncestorOfBST(node1, node2, root.right);
        return root;
    }

    public static TreeNode firstCommonAncestor(TreeNode node1, TreeNode node2, TreeNode root) {
        if (!find(root, node1) || !find(root, node2)) return null;
        return helper(node1, node2, root);
    }

    public static TreeNode helper(TreeNode node1, TreeNode node2, TreeNode root) {
        if (root == null) return root;
        if (node1 == root || node2 == root) return root;
        boolean lef1 = find(root.left, node1), left2 = find(root.left, node2);
        if (lef1 != left2) return root;
        return helper(node1, node2, lef1 ? root.left : root.right);

    }

    public static boolean find(TreeNode root, TreeNode node) {
        if (root == null) return node == null;
        if (root.equals(node)) return true;
        return find(root.left, node) || find(root.right, node);
    }

    public static class Result{
        public TreeNode node;
        public boolean isRes;
        public Result (TreeNode n, boolean beRes) {
            node = n; isRes = beRes;
        }
    }

    public static Result lowerestCommonAncestorHelper(TreeNode node1, TreeNode node2, TreeNode root) {
        if (root == null) return new  Result(null, false);
        if (root == node1 && root == node2) return new Result(root, true);
        Result rx = lowerestCommonAncestorHelper(node1, node2, root.left);
        if (rx.isRes) return rx;
        Result ry = lowerestCommonAncestorHelper(node1, node2, root.right);
        if (ry.isRes) return ry;
        if (rx.node != null && ry.node != null) return new Result(root, true);
        else if (root == node1 || root == node2) return new Result(root, rx.node != null || ry.node != null);
        else return new Result(rx.node == null ? ry.node : rx.node, false);
    }

}
