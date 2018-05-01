package CCI150;

import java.util.Arrays;
import java.util.HashMap;

public class FindLongestCombinationWord {
    public static void main(String[] args) {
        String[] words = {"aaa", "bbb", "test", "berg", "t", "break", "breakfast", "fast", "fat", "ass", "fatass"};
        System.out.println("result: " + findLongestWord(words));
    }

    public static String findLongestWord(String[] words) {
        Arrays.sort(words, (String s1, String s2)->Integer.compare(s2.length(), s1.length()));
        HashMap<String, Boolean> map = new HashMap<>();
        for (String word : words) {
            System.out.println(word);
            map.put(word, true);
        }
        for (String word : words) {
            if (canBeBuilt(word, true, map)) {
                return word;
            }
        }
        return "";
    }

    public static boolean canBeBuilt(String word, boolean isOriginal, HashMap<String, Boolean> map) {
        if (map.containsKey(word) && !isOriginal) return true;
        for (int i = 1; i < word.length(); i++) {
            String left = word.substring(0, i);
            String right = word.substring(i);
            if (map.containsKey(left) && map.get(left) && canBeBuilt(right, false, map)) return true;
        }
        map.put(word, false);
        return false;
    }
}
