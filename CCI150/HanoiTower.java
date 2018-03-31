package CCI150;

import java.util.Stack;
import java.util.Scanner;

public class HanoiTower {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>(), s3 = new Stack<>();
        while (in.hasNext()) {
            s1.push(in.nextInt());
        }
        efficientMove(s1.size(), s1, s2, s3);
        while (!s3.isEmpty()) {
            System.out.println(s3.pop());
        }
    }

    public static void move(int n, Stack<Integer> s1, Stack<Integer> s2, Stack<Integer> s3) {
        if (n == 0) return;
        if (n == 1) {
            s3.push(s1.pop()); return;
        }
        move(n - 1, s1, s2, s3);
        s2.push(s1.pop());
        move(n - 1, s3, s2, s1);
        // 前两次递归只是为了将最下面的那个大饼给从1号杆移到3号杆，可以一次递归到位，直接将0~n-1移到2号杆
        // 于是有了下面更高效的做法
        s3.push(s2.pop());
        move(n - 1, s1, s2, s3);
    }

    public static void efficientMove(int n, Stack<Integer> s1, Stack<Integer> s2, Stack<Integer> s3) {
        if (n <= 0) return;
        efficientMove(n - 1, s1, s3, s2);
        s3.push(s1.pop());
        efficientMove(n - 1, s2, s1, s3);
    }
}
