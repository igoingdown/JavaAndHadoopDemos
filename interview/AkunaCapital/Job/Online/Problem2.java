package interview.AkunaCapital.Job.Online;

public class Problem2 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 9};
        for (int num : arr) {
            System.out.println(f(num));
        }
    }

    public static int f(int num) {
        if (num == 0) return 0;
        if (num == 1) return 1;
        return f(num / 2) + ((num & 1) == 0 ? 1 : 2);
    }
}
