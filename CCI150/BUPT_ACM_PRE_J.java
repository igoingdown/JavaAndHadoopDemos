package CCI150;

import java.util.Scanner;

public class BUPT_ACM_PRE_J {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) getRes(in.nextLong());
    }

    public static void getRes(long n) {
        long pre = 0, cur = 1, index = 0;
        while (cur + pre <= n) {
            long tmp = cur + pre; pre = cur; cur = tmp; index++;
        }
        System.out.print(index + " " + cur + " " + pre + " \n");
    }
}
