package go_valley_class_problems;

import java.util.LinkedList;
import java.util.Queue;

public class BallMazeIII {
    // leetcode 499
    // 与BallMaze的区别是不仅需要用全局的distance二维数组记录起点到每个点的距离，
    //     还要用全局的path二维数组记录起点到每个点的最短distance对应的path(字符顺序最小)，
    //     用BFS不断更新distance和path
    private static final int[] dx = {1, 0, 0, -1};
    private static final int[] dy = {0, -1, 1, 0};
    private static final String[] directions =new String[] {"d", "l", "r", "u"};
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
        int[] start = {0, 0}, hole = {2, 2};
        // System.out.println(shortestDistance(maze, start, hole));
        System.out.println(shortestDistance(maze1, start, hole));
    }

    private static String shortestDistance(int[][] maze, int[] start, int[] hole) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<Pair> queue = new LinkedList<>();
        String[][] path = new String[maze.length][maze[0].length];
        queue.offer(new Pair(start[0], start[1]));
        path[start[0]][start[1]] = "";
        distance[start[0]][start[1]] = 0;
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = current.x, y = current.y, dist = distance[x][y];
                String p = path[x][y];
                while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length &&
                        maze[x][y] == 0 && !(x == hole[0] && y == hole[1])) {
                    x += dx[i];
                    y += dy[i];
                    dist++;
                }
                if (!(x == hole[0] && y == hole[1])) {
                    x -= dx[i];
                    y -= dy[i];
                    dist--;
                }
                String newP = p.concat(directions[i]);
                if (dist < distance[x][y] || (dist == distance[x][y] && path[x][y].compareTo(newP) > 0)) {
                    distance[x][y] = dist;
                    path[x][y] = newP;
                    if (!(x == hole[0] && y == hole[1])) {
                        queue.offer(new Pair(x, y));
                    }
                }
            }
        }
        return distance[hole[0]][hole[1]] == Integer.MAX_VALUE ? "impossible" : path[hole[0]][hole[1]];
    }

}
