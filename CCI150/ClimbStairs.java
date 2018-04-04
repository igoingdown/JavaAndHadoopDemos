package CCI150;

public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(ways(5));
    }

    public static int ways(int n) {
        if (n <= 0) return 0;
        int[] f = new int[n + 1];
        f[0] = 0; f[1] = 1; f[2] = 2; f[3] = 3;
        for (int i = 4; i <= n; i++) f[i] = f[i - 1] + f[i - 2] + f[i - 3];
        return f[n];
    }
}
