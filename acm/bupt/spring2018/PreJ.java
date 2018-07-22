package acm.bupt.spring2018;

import java.util.Scanner;

public class PreJ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) getRes(in.nextLong());
    }

    private static void getRes(long n) {
        long pre = 0, cur = 1, index = 0;
        while (cur + pre <= n) {
            long tmp = cur + pre; pre = cur; cur = tmp; index++;
        }
        System.out.print(index + " " + cur + " " + pre + " \n");
    }
}
