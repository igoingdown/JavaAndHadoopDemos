package CCI150;

public class MaximalSquare {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 0}, {0, 0, 0}, {1, 0, 0}};
        System.out.println(findMaximalSquare(matrix));
    }

    public static int findMaximalSquare(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        Cell[][] cells = preProcess(matrix);
        for (int len = n; len >= 1; len--) {
            for (int i = 0; i + len - 1 < n; i++) {
                for (int j = 0; j + len - 1 < n; j++) {
                    if (cells[i][j].getRightBlacks() >= len &&
                            cells[i][j].getBelowBlacks() >= len &&
                            cells[i + len - 1][j].getRightBlacks() >= len &&
                            cells[i][j + len - 1].getBelowBlacks() >= len) return len;
                }
            }
        }
        return 0;
    }

    public static Cell[][] preProcess(int[][] matrix) {
        int n = matrix.length;
        Cell[][] cells = new Cell[n][n];
        for (int j = n - 1; j >= 0; j--) {
            for (int i = n - 1; i >= 0; i--) {
                cells[i][j] = new Cell();
                if (matrix[i][j] == 0) { // Black
                    cells[i][j].setRightBlacks(1 + (j + 1 < n ? cells[i][j + 1].getRightBlacks() : 0));
                    cells[i][j].setBelowBlacks(1 + (i + 1 < n ? cells[i + 1][j].getBelowBlacks() : 0));
                }
            }
        }
        return cells;
    }

    public static class Cell {
        private int belowBlacks, rightBlacks;
        public Cell() {
            belowBlacks = 0;
            rightBlacks = 0;
        }

        public int getBelowBlacks() {
            return belowBlacks;
        }

        public int getRightBlacks() {
            return rightBlacks;
        }

        public void setBelowBlacks(int belowBlacks) {
            this.belowBlacks = belowBlacks;
        }

        public void setRightBlacks(int rightBlacks) {
            this.rightBlacks = rightBlacks;
        }
    }
}
