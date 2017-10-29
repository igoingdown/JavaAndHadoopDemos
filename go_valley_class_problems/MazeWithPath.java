package go_valley_class_problems;

public class MazeWithPath {
    public static final int[] bias = {1, 0, -1, 0, 1};
    public static final char[] directions = {'D', 'L', 'U', 'R'};
    public static void main(String[] args) {
        char[][] board1 = {
                {'.', 'X', '.', '.', '.', 'X'},
                {'.', '.', '.', 'X', '.', 'X'},
                {'X', 'X', '.', 'X', '.', '.'},
                {'.', 'X', 'X', 'X', '.', 'X'},
                {'.', '.', '.', '.', '.', 'X'},
                {'.', '.', '.', '.', '.', '.'}};
        solveMazeWithMultiPath(board1, 0, 0, 5, 5, "");
        System.out.println("\n\n");
        solveMazeWithOnePath(board1, 0, 0, 5, 5, "");
    }

    public static void solveMazeWithMultiPath(char[][] board, int startX, int startY, int endX, int endY, String path) {
        if (startX >= board.length || startX < 0 || startY >= board[0].length || startY < 0 ||
                board[startX][startY] == 'X') {
            return;
        }
        if (startX == endX && startY == endY) {
            System.out.println(path);
            return;
        }
        board[startX][startY] = 'X';
        for (int i = 0; i < 4; i++) {
            String newPath = path + directions[i];
            int newX = startX + bias[i], newY = startY + bias[i + 1];
            solveMazeWithMultiPath(board, newX, newY, endX, endY, newPath);

        }
        board[startX][startY] = '.';
    }

    public static boolean solveMazeWithOnePath(char[][] board, int startX, int startY, int endX, int endY, String path) {
        if (startX >= board.length || startX < 0 || startY >= board[0].length || startY < 0 ||
                board[startX][startY] == 'X') {
            return false;
        }
        if (startX == endX && startY == endY) {
            System.out.println(path);
            return true;
        }
        board[startX][startY] = 'X';
        for (int i = 0; i < 4; i++) {
            String newPath = path + directions[i];
            int newX = startX + bias[i], newY = startY + bias[i + 1];
            if(solveMazeWithOnePath(board, newX, newY, endX, endY, newPath)) return true;

        }
        return false;
    }

}
