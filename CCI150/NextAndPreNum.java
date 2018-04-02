package CCI150;

import java.util.Scanner;

public class NextAndPreNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            int num = Integer.parseInt(str, 2);
            System.out.println(Integer.toBinaryString(getNext(num)));
            System.out.println(Integer.toBinaryString(getPre(num)));
        }
    }

    public static int getNext(int num) {
        // 01->10, end 0, joint 1
        int c0 = 0, c1 = 0;
        while (((num >> c0) & 1) == 0) ++c0;
        while (((num >> (c0 + c1)) & 1) == 1) ++c1;
        int p = c0 + c1;
        // 0 to set 1
        num |= (1 << (p));
        System.out.println(Integer.toBinaryString(num));
        num &= ((~0) << (p));
        System.out.println(Integer.toBinaryString(num));
        for (int i = 1; i < c1; i++) num |= (1 << (i - 1));
        return num;
    }

    public static int getPre(int num) {
        // 10 -> 01, end 1, seq 0
        int c0 = 0, c1 = 0, p = 0;
        while (((num >> c1) & 1) == 1) ++c1;
        while (((num >> (c0 + c1)) & 1) == 0) ++c0;
        p = c0 + c1;
        // 1 set to 0
        num &= (~(1 << p));
        // rest set 1
        for (int i = p; i > 0; i--) num |= (1 << (i - 1));
        num &= (~0 << (c0 - 1));
        return num;
    }
}
