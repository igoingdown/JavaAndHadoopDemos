package CCI150;

import java.util.*;

public class FindElementInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 10, 19}, {4, 12, 21}, {11, 15, 30}};
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            System.out.println(findElement(matrix, in.nextInt()));
        }
    }

    public static boolean findElement(int[][] matrix, int target) {
        int m = matrix.length, n;
        if (m == 0) return false;
        n = matrix[0].length;
        if (n == 0) return false;
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) col--;
            else row++;
        }
        return false;
    }
}
