package go_valley_class_problems;

import java.util.*;

// 拓扑排序
public class AlienDictionary {
    public static void main (String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.printf("%s%n", alienOrder(words));
    }

    private static String alienOrder(String[] words) {
        StringBuilder res = new StringBuilder("");
        Set<Character> chars = new HashSet<>();
        HashMap<Character, Set<Character> > graph = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) chars.add(word.charAt(i));
        }
        for (Character c : chars) {
            graph.putIfAbsent(c, new HashSet<>());
        }
        // TODO: 找到前后两个word的第一个相异的char，那个word在前，相异的char的优先级越高
        // TODO: 据此可以构建出所有的优先级对，形成graph，然后拓扑排序求解
        // TODO: 拓扑排序中，hashmap的value存的是比key之前的key的set，value为空，表示当前key优先级最高是顶点。
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int k = 0, maxIndex = Math.min(words[i].length(), words[j].length());
                while (k < maxIndex && words[i].charAt(k) == words[j].charAt(k)) k++;
                if (k < maxIndex) graph.get(words[j].charAt(k)).add(words[i].charAt(k));
            }
        }
        Queue<Character> q = new LinkedList<>();
        for (char c: chars) {
            if (graph.get(c).size() == 0) {
                q.add(c);
                res.append(c);
            }
        }
        while (!q.isEmpty()) {
            char cur = q.poll();
            for (char c : chars) {
                if (graph.get(c).contains(cur)) {
                    graph.get(c).remove(cur);
                    if (graph.get(c).size() == 0) {
                        res.append(c);
                        q.offer(c);
                    }
                }
            }
        }
        String finalRes = res.toString();
        return finalRes.length() == chars.size() ? finalRes : "";
    }
}
