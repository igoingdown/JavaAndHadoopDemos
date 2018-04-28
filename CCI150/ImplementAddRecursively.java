package CCI150;

import java.util.Scanner;

public class ImplementAddRecursively {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int a = in.nextInt(), b = in.nextInt();
            System.out.println(addWithoutCalculation(a, b));
        }
    }

    // 如果有进位，两个数相应位都是1，没有进位就是0或者1，计算过程中，表示进位的数会不断左移，，右侧补零，
    // 补为0的那一位和另一个数的另一位加起来一定没有进位，因此表示进位的数的所有比特中1的个数一定会越来越少。
    // 而且会从右至左一次将所有的1变为0
    public static int addWithoutCalculation(int a, int b) {
        System.out.println(Integer.toBinaryString(a) + "\t" + Integer.toBinaryString(b));
        if (b == 0) return a;
        else if (a == 0) return b;
        int c = a ^ b, d = a & b;
        return addWithoutCalculation(c, d << 1);
    }
}
