package CCI150;

public class ImplementMaxWithoutComparison {
    public static void main(String[] args) {
        int res = 0;
        res = getMax(12, -1);
        res = getMax(12, Integer.MIN_VALUE);
        res = getMax(12, 10);
        res = getMax(12, 20);
        res = getMax(-12, 20);
        res = getMax(-12, Integer.MAX_VALUE);
        res = getMax(-12, -10);
        res = getMax(-12, -15);
        System.out.println(res);
    }

    public static int sign(int x) {
        return flip((x >> 31) & 1);
    }

    public static int flip(int x) {
        return 1 ^ x;
    }

    public static int getMax(int a, int b) {
        int c = a - b;
        int sa = sign(a), sb = sign(b), sc = sign(c);
        int use_of_sign_a = sa ^ sb, use_of_sign_c = flip(use_of_sign_a);
        int k = sa * use_of_sign_a + sc * use_of_sign_c, q = flip(k);
        System.out.println(sa + " " + use_of_sign_a + " " + sb + " " + sc + " " + use_of_sign_c + " " + k);
        return a * k + b * q;
    }

}
