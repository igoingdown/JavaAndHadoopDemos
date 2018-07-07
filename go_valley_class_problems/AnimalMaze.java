package go_valley_class_problems;

public class AnimalMaze {
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
        if (solveMazeNoVisit(board1, 0, 0, 4, 4)) System.out.println("yes");
        else System.out.println("no");
        System.out.println();
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
        // 本题不需要回溯，这是因为本题需要返回的结果是bool值，就是说能不能走通，
        //     如果DFS过程中，经过一个节点的第一个path走过这个节点时，通过遍历其后续所有可能的path得知这个节点无法走通
        //     则其他分支即使有可能经过节点也不必再次遍历，因为其后面的所有可能都被遍历过了！
        // 回溯法(所有子问题遍历结束后使用"board[startX][startY] = '.' "将board状态还原到遍历子问题之前)的递归深度是定值，
        //     子问题规模是定值，所以一定不会出现无限递归，但是本题如果回溯会导致TLE！
        // 这是能否到达终点问题和遍历到达终点所有可能路径问题的区别。
        for (int i = 0; i < 4; i++) {
            int newX = startX + bias[i], newY = startY + bias[i + 1];
            if (solveMazeNoVisit(board, newX, newY, endX, endY)) return true;
        }
        return false;
    }
}
