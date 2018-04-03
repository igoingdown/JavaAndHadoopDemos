package CCI150;

public class MS3REN {
    public static void main(String[] args) {
        int[] arr = {5, 7, 4, 8};
        System.out.println(f(arr));
    }
    public static final int maxn = 1500000;
    public static int[] rs = new int[maxn];

    public static void upp(int x, int r) {
        while (x < maxn) {
            rs[x] = Math.max(r, rs[x]);
            x += (x & -x);
        }
    }

    public static int get(int x) {
        int r = 0;
        while (x != 0) {
            r = Math.max(r, rs[x]);
            x -= (x & -x);
        }
        return r;
    }

    public static int f(int[] a) {
        int n = a.length, ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            upp(a[i], i);
            ans = Math.max(ans, get(a[i] - 1) - i);
        }
        return ans;
    }
}
