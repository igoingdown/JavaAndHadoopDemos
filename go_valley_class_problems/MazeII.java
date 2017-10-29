package go_valley_class_problems;

import java.util.LinkedList;
import java.util.Queue;

public class MazeII {
    private static final int[] bias = {1, 0, -1, 0, 1};
    public static void main(String[] args) {
        int[][] maze = {
                {0, 1, 0},
                {0, 0, 1},
                {0, 1, 0}};
        int[][] maze1 = {
                {0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1},
                {1, 1, 0, 1, 0, 0},
                {0, 1, 1, 1, 0, 1},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}};
        int[] start = {0, 0}, end = {2, 2,}, end1 = {5, 5};
        System.out.println(shortestDistance(maze, start, end));
        System.out.println(shortestDistance(maze1, start, end1));

    }

    private static int shortestDistance(int[][] maze, int[] start, int[] end) {
        int[] bias = {1, 0, -1, 0, 1};
        int[][] distance = new int[maze.length][maze[0].length];
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[0].length; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<Pair> pairQueue = new LinkedList<>();
        pairQueue.offer(new Pair(start[0], start[1]));
        distance[start[0]][start[1]] = 0;
        while (!pairQueue.isEmpty()) {
            Pair current = pairQueue.poll();
            for (int i = 0; i < 4; i++) {
                int x = current.x, y = current.y, dist = distance[x][y];
                while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                    x += bias[i];
                    y += bias[i + 1];
                    dist++;
                }
                x -= bias[i];
                y -= bias[i + 1];
                dist--;
                if (distance[x][y] > dist) {
                    distance[x][y] = dist;
                    if (x != end[0] || y != end[1]) {
                        pairQueue.offer(new Pair(x, y));
                    }
                }
            }
        }
        return distance[end[0]][end[1]] == Integer.MAX_VALUE ? -1 : distance[end[0]][end[1]];
    }
}
