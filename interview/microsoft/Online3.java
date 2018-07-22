package interview.microsoft;

public class Online3 {
    public static void main(String[] args) {
        int[] arr = {5, 7, 4, 8};
        System.out.println(f(arr));
    }
    private static final int maxn = 1500000;
    private static int[] rs = new int[maxn];

    private static void upp(int x, int r) {
        while (x < maxn) {
            rs[x] = Math.max(r, rs[x]);
            x += (x & -x);
        }
    }

    private static int get(int x) {
        int r = 0;
        while (x != 0) {
            r = Math.max(r, rs[x]);
            x -= (x & -x);
        }
        return r;
    }

    private static int f(int[] a) {
        int n = a.length, ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            upp(a[i], i);
            ans = Math.max(ans, get(a[i] - 1) - i);
        }
        return ans;
    }
}
