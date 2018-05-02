package CCI150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiPatternMatch {
    public static void main(String[] args) {
        String s = "bibs";
        String[] patterns = {"bi", "bs", "is", "xx"};
        List<List<Integer>> res = multiPatternMatching(s, patterns);
        for (List<Integer> indices : res) {
            if (indices != null) {
                for (int index : indices) System.out.print(index + " ");
                System.out.println();
            } else System.out.println("Not found!");
        }
    }

    public static List<List<Integer>> multiPatternMatching(String s, String[] patterns) {
        SuffixTree tree = new SuffixTree(s);
        List<List<Integer>> res = new ArrayList<>();
        for (String pattern : patterns) res.add(tree.search(pattern));
        return res;
    }

    public static class SuffixTreeNode {
        private SuffixTreeNode[] children = new SuffixTreeNode[256];
        private List<Integer> indices = new ArrayList<>();
        public SuffixTreeNode() {
            Arrays.fill(children, null);
        }
        public void insertString(String s, int i) {
            indices.add(i);
            if (s != null && !s.isEmpty()) {
                if (children[s.charAt(0)] == null) children[s.charAt(0)] = new SuffixTreeNode();
                SuffixTreeNode child = children[s.charAt(0)];
                child.insertString(s.substring(1), i);
            }
        }

        public List<Integer> search(String s) {
            if (s == null || s.isEmpty()) return indices;
            if (children[s.charAt(0)] != null) {
                return children[s.charAt(0)].search(s.substring(1));
            }
            return null;
        }
    }

    public static class SuffixTree {
        private SuffixTreeNode root = new SuffixTreeNode();
        public SuffixTree(String s) {
            for (int i = 0; i < s.length(); i++) {
                root.insertString(s.substring(i), i);
            }
        }

        public List<Integer> search(String s) {
            return root.search(s);
        }
    }
}
