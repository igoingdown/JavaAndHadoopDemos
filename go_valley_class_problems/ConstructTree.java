package go_valley_class_problems;


public class ConstructTree {
    public static void main(String[] args) {
        String preOrder = "ABDEHICFGJ", inOrder = "DBHEIAFCGJ", postOrder = "DHIEBFJGCA";
        TreeNode<Character> root = constructTreeFromPreAndInOrder(preOrder, inOrder);
        System.out.println("pre + in order res:");
        preTraverse(root);
        System.out.println("\n" + preOrder);
        inTraverse(root);
        System.out.println("\n" + inOrder);
        System.out.println("post + in order res:");
        TreeNode<Character> tmp = constructTreeFromPostAndInOrder(postOrder, inOrder);
        postTraverse(tmp);
        System.out.println("\n" + postOrder);
        inTraverse(tmp);
        System.out.println("\n" + inOrder);

    }

    private static void preTraverse(TreeNode<Character> root) {
        if (root == null) return;
        System.out.print(root.getVal());
        preTraverse(root.getLeft());
        preTraverse(root.getRight());
    }

    private static void inTraverse(TreeNode<Character> root) {
        if (root == null) return;
        inTraverse(root.getLeft());
        System.out.print(root.getVal());
        inTraverse(root.getRight());
    }

    private static void postTraverse(TreeNode<Character> root) {
        if (root == null) return;
        postTraverse(root.getLeft());
        postTraverse(root.getRight());
        System.out.print(root.getVal());
    }


    private static TreeNode<Character> constructTreeFromPreAndInOrder(String preOrder, String inOrder) {
        if (preOrder.length() == 0) return null;
        return constructPreAndIn(preOrder, 0, preOrder.length(),
                inOrder, 0, inOrder.length());
    }

    private static TreeNode<Character> constructTreeFromPostAndInOrder(String postOrder, String inOrder) {
        if (postOrder.length() == 0) return null;
        return constructPostAndIn(postOrder, 0, postOrder.length(),
                inOrder, 0, inOrder.length());
    }

    private static TreeNode<Character> constructPostAndIn(String postOrder, int postStart, int postEnd,
                                               String inOrder, int inStart, int inEnd) {
        if (postStart == postEnd) return null;
        TreeNode<Character> root = new TreeNode<Character>(postOrder.charAt(postEnd - 1));
        int i = inStart;
        for (; i < inEnd; i++) {
            if (inOrder.charAt(i) == postOrder.charAt(postEnd - 1)) break;
        }
        if (i == inEnd) return null;
        root.setLeft(constructPostAndIn(postOrder, postStart, postEnd - inEnd + i,
                inOrder, inStart, i));
        root.setRight(constructPostAndIn(postOrder, postEnd - inEnd + i, postEnd - 1,
                inOrder, i + 1, inEnd));
        return root;
    }

    private static TreeNode<Character> constructPreAndIn(String preOrder, int preStart, int preEnd,
                                      String inOrder, int inStart, int inEnd) {
        if (preStart == preEnd) return null;
        TreeNode<Character> root = new TreeNode<Character>(preOrder.charAt(preStart));
        int i = inStart;
        for (; i < inEnd; i++) {
            if (inOrder.charAt(i) == preOrder.charAt(preStart)) break;
        }
        if (i == inEnd) return root;
        root.setLeft(constructPreAndIn(preOrder, preStart + 1, preStart + i - inStart + 1,
                inOrder, inStart, i));
        root.setRight(constructPreAndIn(preOrder, preStart + i - inStart + 1, preEnd,
                inOrder, i + 1, inEnd));
        return root;
    }
}
