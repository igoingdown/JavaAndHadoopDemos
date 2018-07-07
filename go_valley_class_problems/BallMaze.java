package go_valley_class_problems;

import java.util.LinkedList;
import java.util.Queue;

public class BallMaze {
    private static final int[] bias = {1, 0, -1, 0, 1};
    public static void main(String[] args) {
        int[][] board = {{0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}};
        if (canReach(board, 0, 0, 4, 4)) System.out.println("Y");
        else System.out.println("N");
    }

    private static boolean canReach(int[][] board, int startX, int startY, int endX, int endY) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(startX, startY));
        while (!q.isEmpty()) {
            Pair current = q.poll();
            if (current != null && current.x == endX && current.y == endY) return true;
            if (current != null) visited[current.x][current.y] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = current.x, nextY = current.y;
                while (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && board[nextX][nextY] == 0) {
                    nextX += bias[i];
                    nextY += bias[i + 1];
                }
                nextX -= bias[i];
                nextY -= bias[i+1];
                if (!visited[nextX][nextY]) q.offer(new Pair(nextX, nextY));
            }
        }
        return false;
    }
}
