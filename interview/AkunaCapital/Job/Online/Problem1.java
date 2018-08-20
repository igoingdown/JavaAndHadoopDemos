package interview.AkunaCapital.Job.Online;

public class Problem1 {
    // 类似leetcode 54。画出完整矩形之后就很容易看出规律
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
