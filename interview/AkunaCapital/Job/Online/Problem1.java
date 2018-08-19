package interview.AkunaCapital.Job.Online;

public class Problem1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(sumFunction(arr));
    }

    public static long sumFunction(int[] arr) {
        int n = arr.length;
        long sum = 0;
        for (int i = 0; i < n; i++) sum += (n - i) * (i + 1) * arr[i];
        return sum;
    }
}
