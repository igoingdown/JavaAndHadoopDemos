package CCI150;

public class RotateMatrix {
    public static void main(String[] args) {
        int n = 3;
        int[][] matrix = {{1,2,3}, {4, 5, 6}, {7, 8, 9}};
        for (int[] v: matrix) {
            for (int num : v) System.out.print(num + " ");
            System.out.println();
        }
        System.out.println();
        rotateMatrix(matrix);
        for (int[] v: matrix) {
            for (int num : v) System.out.print(num + " ");
            System.out.println();
        }
    }

    static void rotateMatrix(int[][] matrix) {
        int n = matrix.length; if (n == 0) return;
        for (int low = 0, high = n - 1; low < high; low++, high--) {
            for (int i = 0; i < n; i++) {
                int tmp = matrix[low][i]; matrix[low][i] = matrix[high][i]; matrix[high][i] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j]; matrix[i][j] = matrix[j][i]; matrix[j][i] = tmp;
            }
        }
    }
}
