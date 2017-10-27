package go_valley_class_problems;

public class Maze {
    private static final int[] bias = {1, 0, -1, 0, 1};
    public static void main(String[] args) {
        char[][] board = {
                {'.', 'X', '.'},
                {'.', '.', 'X'},
                {'.', 'X', '.'}};
        char[][] board1 = {
                {'.', 'X', '.', '.', '.', 'X'},
                {'.', '.', '.', 'X', '.', 'X'},
                {'X', 'X', '.', 'X', '.', '.'},
                {'.', 'X', 'X', 'X', '.', 'X'},
                {'.', '.', '.', '.', '.', 'X'},
                {'.', '.', '.', '.', '.', '.'}};
        boolean[][] visited = new boolean[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                visited[i][j] = false;
            }
        }
        if (solveMaze(board, 0, 0, 2, 2, visited)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
        System.out.println("");
    }
    private static boolean solveMaze(char[][] board, int startX, int startY, int endX, int endY, boolean[][] visited) {
        if (startX >= board.length || startY >= board[0].length || startX < 0 || startY < 0 ||
                board[startX][startY] == 'X' ||
                visited[startX][startY]) {
            return  false;
        }
        if (startX == endX && startY == endY) {
            return true;
        }
        visited[startX][startY] = true;
        for (int i = 0; i < 4; i++) {
            int newX = startX + bias[i], newY = startY + bias[i + 1];
            if (solveMaze(board, newX, newY, endX, endY, visited)) return true;
        }
        return false;
    }
    private static boolean solveMazeNoVisit(char[][] board, int startX, int startY, int endX, int endY) {
        if (startX >= board.length || startY >= board[0].length || startX < 0 || startY < 0 || board[startX][startY] == 'X') {
            return false;
        }
        if (startX == endX && startY == endY) {
            return true;
        }
        board[startX][startY] = 'X';
        for (int i = 0; i < 4; i++) {
            int newX = startX + bias[i], newY = startY + bias[i + 1];
            if (solveMazeNoVisit(board, newX, newY, endX, endY)) return true;
        }
        return false;
    }
}
