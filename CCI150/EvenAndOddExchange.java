package CCI150;

import java.util.Scanner;

public class EvenAndOddExchange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            int num = exchange(Integer.parseInt(str, 2));
            System.out.println(Integer.toBinaryString(num));
        }
    }
    public static int exchange(int num) {
        return ((num & 0xaaaaaaaa) >> 1) | ((num & 0x55555555) << 1);
    }
}
