package go_valley_class_problems;

public class LongestCommonSequence {
    public static void main(String[] args) {
        String a = "abcfbc", b = "abfcab";
        System.out.println(lcs(a, b));
    }

    public static int lcs(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        // dp[i][j]表示a[0,i]和b[0,j]的最长公共序列的长度。
        for (int i = 1; i < a.length() + 1; i++) {
            for (int j = 1; j < b.length() + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }
}
