package CCI150;

import java.util.HashSet;

public class StringPartition {
    public static void main(String[] args) {
        String word = "thit";
        HashSet<String> dict = new HashSet<>();
        dict.add("hit");
        dict.add("it");
        dict.add("i");
        System.out.println(parseString(word, 0, dict));
    }

    public static int parseString(String word, int start_index, HashSet<String> dict) {
        if (start_index >= word.length()) return dict.contains(word) ? 0 : word.length();
        String left = word.substring(0, start_index + 1);
        String right = word.substring(start_index + 1);
        return Math.min(parseString(right, 0, dict) + (dict.contains(left) ? 0 : left.length()), parseString(word, start_index + 1, dict));
    }
}
