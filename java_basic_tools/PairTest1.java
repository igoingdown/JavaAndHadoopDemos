package java_basic_tools;

import javafx.util.Pair;

/**
 * Created by zhaomingxing on 2017/1/6.
 */
public class PairTest1 {
    public static void main(String[] args) {
        String[] words = {"hello", "world", "jack", "and", "jane"};
        Pair<String, String> minAndMax = minmax(words);
        System.out.println("pair first: " + minAndMax.getKey());
        System.out.println("pair second: " + minAndMax.getValue());
    }

    public static Pair<String, String> minmax(String[] s) {
        if (s == null || s.length == 0) {
            return null;
        } else {
            String min = s[0];
            String max = s[0];
            for (String str: s) {
                if (min.compareTo(str) > 0) {
                    min = str;
                }
                if (max.compareTo(str) < 0) {
                    max = str;
                }
            }
            return new Pair<String, String>(min, max);
        }
    }
}
