package go_valley_class_problems;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solve(board);
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println("");
        }
    }

    private static int m, n;
    private static int[] bias = {1, 0, -1, 0, 1};

    private static void bfs(char[][] board, int i, int j) {
        if (board[i][j] != 'O') return;
        Queue<Integer> q = new LinkedList<>();
        q.offer(i * n + j);
        while (!q.isEmpty()) {
            int p = q.poll();
            board[p / n][p % n] = 'F';
            for (int k = 0; k < 4; k++) {
                int nx = p / n + bias[k], ny = p % n + bias[k + 1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 'O') {
                    q.offer(nx * n + ny);
                }
            }
        }

    }
    public static void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            bfs(board, i, 0);
            bfs(board, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            bfs(board, 0, j);
            bfs(board, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = (board[i][j] == 'F' ? 'O' : 'X');
            }
        }
    }
}
