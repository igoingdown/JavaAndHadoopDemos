package go_valley_class_problems;

public class Trie {
    public static TrieNode root = new TrieNode();

    public static void main() {
        System.out.println("a");
    }

    public static void insert(String word) {
        if (word == null || word.length() == 0) return;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord = true;
    }

    public static boolean search(String word) {
        if (word == null || word.length() == 0) return true;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) return false;
            node = node.children[index];
        }
        return node.isWord;
    }

    public static boolean startWith(String prefix) {
        if (prefix == null || prefix.length() == 0) return true;
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null) return false;
            node = node.children[index];
        }
        return true;
    }


}
