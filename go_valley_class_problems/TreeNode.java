package go_valley_class_problems;

public class TreeNode {
    private char val;
    private TreeNode left;
    private TreeNode right;
    public TreeNode(char x) {
        val = x;
        left = null;
        right = null;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public char getVal() {
        return val;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setVal(char val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return super.toString() + val;
    }
}
