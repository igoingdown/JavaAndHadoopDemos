package package_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhaomingxing on 2017/6/13.
 */
public class HashTest {
    public static void main(String[] args) {
        testHash();
        System.out.println("good");
        testString();
    }

    private static void testHash(){
        HashMap<Integer, Integer> hMap = new HashMap<>();
        hMap.put(10, 20);
        System.out.println(hMap.get(10));
        System.out.println(hMap.get(200));
        hMap.put(1000, 2000);
        for (Integer n: hMap.keySet()) {
            System.out.println("key: " + n + "\t value: " + hMap.get(n));
        }

        HashSet<Integer> hSet = new HashSet<>();
        hSet.add(10);
        for (Integer n : hSet) {
            System.out.println(n);
        }

        Queue<Integer> nQue = new LinkedList<>();
        nQue.add(1000);
        nQue.add(2000);
        while (!nQue.isEmpty()) {
            Integer n = nQue.poll();
            System.out.println(n);
        }
    }

    private static void testString() {
        String s = new String("you are a fool!");
        for (String t: s.split("\\f")) {
            System.out.println(t);
        }
    }
}



