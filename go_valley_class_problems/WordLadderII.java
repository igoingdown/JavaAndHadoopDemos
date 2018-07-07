package go_valley_class_problems;

import java.util.*;

public class WordLadderII {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        for (List<String> path : wordLadders(wordList, beginWord, endWord)) {
            for (String word : path) System.out.print(word + " ");
            System.out.println();
        }
    }

    private static List<List<String>> wordLadders(String[] wordList, String beginWord, String endWord) {
        Queue<LinkedList<String>> q = new LinkedList<>(), next = new LinkedList<>();
        HashMap<String, Boolean> visited = new HashMap<>();
        for (String word : wordList) visited.put(word, false);
        LinkedList<String> initialPath = new LinkedList<>();
        initialPath.add(beginWord);
        q.offer(initialPath);
        List<List<String>> res = new LinkedList<>();

        while (!q.isEmpty()) {
            HashSet<String> layerVisited = new HashSet<>();
            while (!q.isEmpty()) {
                LinkedList<String> cur = q.poll();
                if (cur.getLast().equals(endWord)) res.add(cur);
                StringBuilder curBuilder = new StringBuilder(cur.getLast());
                for (int i = 0; i < curBuilder.length(); i++) {
                    char tmp = curBuilder.charAt(i);
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != tmp) {
                            curBuilder.setCharAt(i, c);
                            String candidate = curBuilder.toString();
                            if (visited.containsKey(candidate) && !visited.get(candidate)) {
                                LinkedList<String> candidatePath = new LinkedList<>(cur);
                                candidatePath.add(candidate);
                                next.offer(candidatePath);
                                layerVisited.add(candidate);
                            }
                        }
                    }
                    curBuilder.setCharAt(i, tmp);
                }
            }
            for (String word : layerVisited) visited.put(word, true);
            Queue<LinkedList<String>> tmp = new LinkedList<>(q);
            q = next;
            next = tmp;
            if (res.size() > 0) break;
        }
        return res;
    }

}
