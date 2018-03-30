package CCI150;

public class ClearMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {3, 0, 5}, {6, 0, 9}};
        for (int[] v: matrix) {
            for (int n : v) System.out.print(n + " ");
            System.out.println();
        }
        clearMatrix(matrix);
        System.out.println();
        for (int[] v : matrix) {
            for (int n : v) System.out.print(n + " ");
            System.out.println();
        }
    }

    public static void clearMatrix(int[][] matrix) {
        int m = matrix.length; if(m == 0) return;
        int n = matrix[0].length; if(n == 0) return;
        boolean firstColumnZeros = false;
        for (int row = 0; row < m; row++) {
            if (matrix[row][0] == 0) firstColumnZeros = true;
        }
        for (int row = 0; row < m; row++) {
            for (int column = 1; column < n; column++) {
                if (matrix[row][column] == 0) matrix[row][0] = 0;
            }
        }
        for (int row = m - 1; row >= 0; row--) {
            for (int column = 0; column < n; column++) {
                if (matrix[row][0] == 0) matrix[row][column] = 0;
            }
        }
        if (firstColumnZeros) {
            for (int row = 0; row < m; row++) matrix[row][0] = 0;
        }
    }
}
