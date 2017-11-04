package go_valley_class_problems;

public class TreeNode<T> {
    private T val;
    private TreeNode left;
    private TreeNode right;
    public TreeNode(T x) {
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

    public T getVal() {
        return val;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setVal(T val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return super.toString() + val;
    }
}
