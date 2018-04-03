package CCI150;

import java.util.Scanner;

public class ImplementDevideMultiplyAndMinusWithAdd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a, b;
        while (in.hasNext()) {
            a = in.nextInt(); b = in.nextInt();
            System.out.print(minus(a, b) + " ");
            System.out.print(devide(a, b) + " ");
            System.out.print(multiply(a, b) + "\n");
        }

    }

    public static int minus(int a, int b) {
        // System.out.println(Integer.toBinaryString(b));
        int minusB = ((~b) + 1);
        // System.out.println(Integer.toBinaryString(minusB));
        return a + minusB;
    }

    public static int multiply(int a, int b) {
        int x = abs(a), y = abs(b);
        if (x < y) return multiply(b, a);
        int sum = 0;
        for (int i = 0; i < y; i++) sum += x;
        return ((a < 0 && b > 0) || (a > 0 && b < 0)) ? minus(0, sum) : sum;
    }

    public static int abs(int a) {
        return a >= 0 ? a : minus(0, a);
    }

    public static int devide(int a, int b) {
        int x = abs(a), y = abs(b);
        int i = 0;
        while (x > 0) {
            x = minus(x, y);
            if (x >= 0) ++i;
        }
        return ((a < 0 && b > 0) || (a > 0 && b < 0)) ? minus(0, i) : i;
    }

}
