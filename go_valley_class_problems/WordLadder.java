package go_valley_class_problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        System.out.println(minLadderLen(beginWord, wordList, endWord));
    }

    private static int minLadderLen(String beginWord, String[] words, String endWord) {
        Queue<String> q = new LinkedList<>(), next = new LinkedList<>();
        q.offer(beginWord);
        HashMap<String, Boolean> visit = new HashMap<>();
        for (String s : words) visit.put(s, false);
        int res = 1;
        boolean found = false;
        while (!q.isEmpty()) {
            while (!q.isEmpty()) {
                String cur = q.poll();
                if (cur.equals(endWord)) {
                    found = true;
                    break;
                }
                StringBuilder curBuilder = new StringBuilder(cur);
                for (int i = 0; i < cur.length(); i++) {
                    char tmp = curBuilder.charAt(i);
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != tmp) {
                            curBuilder.setCharAt(i, c);
                            String candidate = curBuilder.toString();
                            if (visit.containsKey(candidate) && !visit.get(candidate)) {
                                next.offer(candidate);
                                visit.put(candidate, true);
                            }
                        }
                    }
                    curBuilder.setCharAt(i, tmp);
                }
            }
            if (found) break;;
            Queue<String> tmp = new LinkedList<>(q);
            q = next;
            next = tmp;
            res++;
        }
        return res;
    }
}
