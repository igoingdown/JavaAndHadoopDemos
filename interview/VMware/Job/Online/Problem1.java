package interview.VMware.Job.Online;

import java.util.*;

public class Problem1 {
    // AC 9%
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        if (n < 2) {
            System.out.println("" + 0 + " " + "0");
        } else if (n == 3) {
            System.out.println("" + 3 + " " + 1);
        } else if (n == 4) {
            System.out.println("" + 6 + " " + 3);
        } else {
            System.out.print(3 * (n - 2));
            System.out.print(" ");
            System.out.print(n * (n - 1) * (n - 2) / 6 - (n - 1) * (n - 2) * (n - 3) / 6);
        }
    }
}
