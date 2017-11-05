package go_valley_class_problems;

public class TrieNode {
    public boolean isWord;
    public char var;
    public TrieNode[] children;
    public TrieNode() {
        children = new TrieNode[26];
        var = 0;
        isWord = false;
    }
}
