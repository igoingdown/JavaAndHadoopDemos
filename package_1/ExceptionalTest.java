package package_1;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.Date;

/**
 * Created by zhaomingxing on 2017/1/6.
 */
public class ExceptionalTest {
    public static void main(String[] args) {
        int i = 0;
        int ntry = 1000000;
        Stack s = new Stack();
        long s1;
        long s2;
        System.out.println("Testing for empty stack");
        s1 = new Date().getTime();
        for (i = 0; i < ntry; i++) {
            if (!s.empty()) {
                s.pop();
            }
        }
        s2 = new Date().getTime();
        System.out.println(s2 - s1 + " ms");
        s1 = new Date().getTime();
        for (i = 0; i < ntry; i++) {
            try {
                s.pop();
            }
            catch (EmptyStackException e) {
            }
        }
        s2 = new Date().getTime();
        System.out.println(s2 - s1 + " ms");
    }
}
