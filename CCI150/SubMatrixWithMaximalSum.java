package CCI150;

public class SubMatrixWithMaximalSum {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 1}, {3, 2, 2}, {-5, -2, -1}};
        System.out.println(findSubMatrixWithMaximalSum(matrix));
        System.out.println(findLikeMaximalSubArraySum(matrix));
    }

    public static int findSubMatrixWithMaximalSum(int[][] matrix) {
        if (matrix == null) return 0;
        int n = matrix.length;
        if (n == 0) return 0;
        int[][] sums = preProcess(matrix);
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int row_len = 1; row_len + i - 1 < n; row_len++) {
                    for (int column_len = 1; column_len + j - 1 < n; column_len++) {
                        int s1 = (i == 0 || j == 0) ? 0 : sums[i - 1][j - 1], s2 = (i == 0) ? 0 : sums[i - 1][j + column_len - 1];
                        int s3 = (j == 0) ? 0 : sums[i + row_len - 1][j - 1], s4 = sums[i + row_len - 1][j + column_len - 1];
                        int area = s1 + s4 - s2 - s3;
                        res = Math.max(area, res);
                    }
                }
            }
        }
        return res;
    }

    public static int[][] preProcess(int[][] matrix) {
        int n = matrix.length;
        int[][] sums = new int[n][n];
        sums[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) sums[i][0] = (sums[i - 1][0] + matrix[i][0]);
        for (int j = 1; j < n; j++) sums[0][j] = (sums[0][j - 1] + matrix[0][j]);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i][j];
        }
        return sums;
    }

    public static int findLikeMaximalSubArraySum(int[][] matrix) {
        if (matrix == null) return 0;
        int n = matrix.length;
        if (n == 0) return 0;
        int[][] sums = preProcess(matrix);
        int res = Integer.MIN_VALUE;
        for (int rowStart = 0; rowStart < n; rowStart++) {
            for (int rowEnd = rowStart; rowEnd < n; rowEnd++) {
                int column_start = 0;
                for (int col = 0; col < n; col++) {
                    int s1 = (rowStart == 0 || column_start == 0) ? 0 : sums[rowStart - 1][column_start - 1];
                    int s2 = (rowStart == 0) ? 0 : sums[rowStart - 1][col];
                    int s3 = (column_start == 0) ? 0 : sums[rowEnd][column_start - 1];
                    int s4 = sums[rowEnd][col];
                    int area = s1 + s4 - s2 - s3;
                    if (area < 0) column_start = col + 1;
                    else res = Math.max(area, res);
                }
            }
        }
        return res;
    }
}
