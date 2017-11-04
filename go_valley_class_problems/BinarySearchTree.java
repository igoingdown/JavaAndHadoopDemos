package go_valley_class_problems;

public class BinarySearchTree {
    private static TreeNode<Integer> root;
    public static void main(String[] args) {
        constructBST();

        System.out.println("");
    }

    private static boolean constructBST() {
        root = new TreeNode(30);
        root.setLeft(new TreeNode(18));
        root.setRight(new TreeNode(34));
        root.getLeft().setLeft(new TreeNode(13));
        root.getLeft().setRight(new TreeNode(24));
        root.getLeft().getRight().setLeft(new TreeNode(22));
        root.getLeft().getRight().setRight(new TreeNode(27));
        root.getRight().setLeft(new TreeNode(31));
        root.getRight().setRight(new TreeNode(40));
        root.getRight().getRight().setRight(new TreeNode(47));
        return true;
    }

    public static boolean findElem(int x) {
        TreeNode<Integer> t = root;
        while (t != null) {
            if (t.getVal() < x) t = t.getLeft();
            else if (t.getVal() > x) t = t.getRight();
            else return true;
        }
        return false;
    }

    private static boolean addEle(int x) {
        if (root == null) {
            root = new TreeNode<Integer>(x);
            return true;
        }
        TreeNode<Integer> t = root;
        while (t != null) {
            if (t.getVal() < x) {
                if (t.getLeft() == null) {
                    t.setLeft(new TreeNode<>(x));
                    return true;
                } else {
                    t = t.getLeft();
                }
            } else if (t.getVal() > x) {
                if (t.getRight() == null) {
                    t.setRight(new TreeNode<>(x));
                    return true;
                } else {
                    t = t.getRight();
                }
            } else {
                return false;
            }
        }
        return false;
    }


    private static boolean delete(int x) {


        return true;
    }

    private static void inOrder(TreeNode<Integer> root) {
        if (root == null) return;
        inOrder(root.getLeft());
        System.out.println(root.getVal());
        inOrder(root.getRight());
    }
}
