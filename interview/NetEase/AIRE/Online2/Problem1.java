package interview.NetEase.AIRE.Online2;

import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n > 0) {
            int num = scanner.nextInt();
            if (num <= 5000) System.out.println(0);
            else System.out.println(CalculateFee(num - 5000));
            n--;
        }
    }

    private static int CalculateFee(int num) {
        double res = 0.0;
        if (num > 80000) {
            res += (num - 80000) * 0.45;
            num = 80000;
        }
        if (num > 55000) {
            res += (num - 55000) * 0.35;
            num = 55000;
        }
        if (num > 35000) {
            res += (num - 35000) * 0.3;
            num = 35000;
        }
        if (num > 25000) {
            res += (num - 25000) * 0.25;
            num = 25000;
        }
        if (num > 12000) {
            res += (num - 12000) * 0.2;
            num = 12000;
        }
        if (num > 3000) {
            res += (num - 3000) * 0.1;
            num = 3000;
        }
        res += num * 0.03;
        return (int)(res + 0.5);
    }
}
