package CCI150;
import java.util.*;

public class TailZeros {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            System.out.println(tailZeros(n));
            System.out.println(tailZerosEfficient(n));
        }
    }

    public static int tailZeros(int n) {
        int res = 0;
        if (n < 5) return res;
        int x = (int)(Math.log(n) / Math.log(5));
        for (int i = 1; i <= x; i++) res += n / (int)(Math.pow(5.0, i));
        return res;
    }

    public static int tailZerosEfficient(int n) {
        int res = 0, count = n / 5;
        while (count > 0) {
            res += count;
            count /= 5;
        }
        return res;
    }
}
