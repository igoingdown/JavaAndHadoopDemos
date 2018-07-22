package interview.microsoft;

import java.util.Collections;
import java.util.LinkedList;

public class Online1 {
    public static void main(String[] args) {
        System.out.println(foo(310));
        System.out.println(foo(918));
    }

    private static long foo(long key) {
        LinkedList<Long> s = new LinkedList<>();
        while (key != 0) {
            s.addLast(key % 10); key /= 10;
        }
        Collections.sort(s);
        if (s.get(0) == 0) {
            for (int i = 0; i < s.size(); i++) {
                if (s.get(i) != 0) {
                    long temp = s.get(i);
                    s.set(i, s.get(0));
                    s.set(0, temp);
                    break;
                }
            }
        }
        long res = 0;
        for (long n : s) res = res * 10 + n;
        return res;
    }
}

