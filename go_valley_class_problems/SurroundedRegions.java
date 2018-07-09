package go_valley_class_problems;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    // 找出所有被包围的区域，可以反向思考，从边缘部位用BFS或者DFS标记出没被包围的区域，将其余区域均设置为包围区域即可
    // 从边缘区域入手开始BFS或DFS的原因是如果一个区域没有被包围，一定存在一个在边缘的出口(或者入口)

    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solve(board);
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

        System.out.println();

        char[][] board1 = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solveDFS(board1);
        for (char[] row : board1) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
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

    private static void dfs(char[][] board, int i, int j) {
        board[i][j] = 'F';
        for (int k = 0; k < 4; k++) {
            int x = i + bias[k], y = j + bias[k + 1];
            if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') dfs(board, x, y);
        }
    }

    private static void solveDFS(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][n - 1] == 'O') dfs(board, i, n -1 );
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[m - 1][j] == 'O') dfs(board, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] == 'F' ? 'O' : 'X';
            }
        }
    }

    private static void solve(char[][] board) {
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
