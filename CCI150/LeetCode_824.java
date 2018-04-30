package CCI150;

import java.util.Arrays;

public class LeetCode_824 {
    public static void main(String[] args) {
        String s = "I speak Goat Latin";
        System.out.println(toGoatLatin(s));
    }

    public static String toGoatLatin(String S) {
        String[] words = S.split(" ");
        StringBuilder res = new StringBuilder(), tmp;
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            if (word.length() > 0 && (word.charAt(0) == 'a' || word.charAt(0) == 'e' || word.charAt(0) == 'i' || word.charAt(0) == 'o' ||word.charAt(0) == 'u')) {
                tmp = new StringBuilder(words[i]);
            } else {
                tmp = new StringBuilder(words[i].substring(1));
                tmp.append(words[i].charAt(0));
            }
            tmp.append("ma");
            char[] last_part = new char[i + 1];
            Arrays.fill(last_part, 'a');
            tmp.append(new String(last_part));
            res.append(tmp.toString() + (i + 1 == words.length ? "" : " "));
        }
        return res.toString();
    }
}
