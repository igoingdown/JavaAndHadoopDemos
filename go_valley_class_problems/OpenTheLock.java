package go_valley_class_problems;

import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class OpenTheLock {
    public static void main(String[] args) {
        String[] deadEnds = {"1002","1220","0122","0112","0121"};
        System.out.println(openLock(deadEnds, "1200"));
    }

    public static int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Queue<String> next = new LinkedList<>();
        HashMap<String, Integer> aMap = new HashMap<String, Integer>();
        for (String s : deadends) aMap.put(s, -1);
        int layer = 1;
        q.offer("0000");
        while (!q.isEmpty()) {
            while (!q.isEmpty()) {
                String cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    StringBuilder tmp = new StringBuilder(cur);
                    char c = tmp.charAt(i);
                    if (tmp.charAt(i) == '9') tmp.setCharAt(i, '0');
                    else {
                        tmp.setCharAt(i, ++c);
                        c--;
                    }
                    String child = tmp.toString();
                    if (child.equals(target)) return layer;
                    if (aMap.getOrDefault(child, 0) == 0) {
                        aMap.put(child, layer);
                        next.offer(child);
                    }
                    tmp.setCharAt(i, c);
                    if (tmp.charAt(i) == '0') tmp.setCharAt(i, '9');
                    else {
                        tmp.setCharAt(i, --c);
                        c++;
                    }
                    child = tmp.toString();
                    if (child.equals(target)) return layer;
                    if (aMap.getOrDefault(child, 0) == 0) {
                        aMap.put(child, layer);
                        next.offer(child);
                    }
                }
            }
            q = next;
            layer++;
            next = new LinkedList<>();
        }
        return target.equals("0000") ? 0 : -1;
    }
}
