package go_valley_class_problems;

public class BinarySearchTree {
    private static TreeNode<Integer> root;
    public static void main(String[] args) {
        constructBST();
        if (findElem(22)) System.out.println("find 22");
        if (addEle(15)) System.out.println("add 15 success");
        inOrder(root);
        if (delete(18)) System.out.println("delete 18 success");
        inOrder(root);
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
            if (t.getVal() > x) t = t.getLeft();
            else if (t.getVal() < x) t = t.getRight();
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
            if (t.getVal() > x) {
                if (t.getLeft() == null) {
                    t.setLeft(new TreeNode<>(x));
                    return true;
                } else {
                    t = t.getLeft();
                }
            } else if (t.getVal() < x) {
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
        if (root == null) return false;
        if (root.getVal() == x) {
            root = null;
            return true;
        }
        TreeNode<Integer> t = root;
        while (t != null) {
            if (t.getVal() > x) {
                if (t.getLeft() != null && (int)t.getLeft().getVal() != x) {
                    t = t.getLeft();
                } else if (t.getLeft() == null) {
                    return false;
                } else {
                    deleteNode(t.getLeft());
                    return true;
                }

            } else if (t.getVal() < x) {
                if (t.getRight() != null && (int)t.getRight().getVal() != x) {
                    t = t.getRight();
                } else if (t.getRight() == null) {
                    return false;
                } else {
                    deleteNode(t.getRight());
                }
            } else {
                return false;
            }
        }
        return false;
    }


    public static TreeNode<Integer> deleteNode(TreeNode<Integer> node) {
        if (node.getLeft() == null && node.getRight() == null) return null;
        else if (node.getLeft() == null) return node.getRight();
        else if (node.getRight() == null) return node.getLeft();
        else {
            node.setVal(findAndDelete(node));
            return node;
        }
    }

    private static int findAndDelete(TreeNode<Integer> node) {
        if (node.getLeft().getRight() == null) {
            int res = (int)node.getLeft().getVal();
            node.setLeft(node.getLeft().getLeft());
            return res;
        } else {
            node = node.getLeft();
            while(node.getRight().getRight() != null) {
                node = node.getRight();
            }
            int res = (int)node.getRight().getVal();
            node.setRight(node.getRight().getLeft());
            return res;
        }
    }

    private static void inOrder(TreeNode<Integer> t) {
        if (t == null) return;
        inOrder(t.getLeft());
        System.out.println(t.getVal());
        inOrder(t.getRight());
    }
}
