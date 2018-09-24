package interview.Airbnb.Job.Experience;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Kosaraju {
    private static int N;
    private static Stack<Integer> stack = new Stack<>();
    private static int[][] graph;
    private static int[][] reversedGraph;
    private static boolean[] visited;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] nAndM = in.nextLine().split(" ");
            N = Integer.parseInt(nAndM[0]);
            int M = Integer.parseInt(nAndM[1]);
            graph = new int[N + 1][N + 1];
            reversedGraph = new int[N + 1][N + 1];
            visited = new boolean[N + 1];
            for (int i = 0; i < M; i++) {
                String[] uAndV = in.nextLine().split(" ");
                int u = Integer.parseInt(uAndV[0]), v = Integer.parseInt(uAndV[1]);
                graph[u][v] = 1;
                reversedGraph[v][u] = 1;
            }
            System.out.print(kosaraju());
        }
    }

    private static void dfs1(int u) {
        visited[u] = true;
        for (int v = 1; v <= N; v++) {
            if (!visited[v] && graph[u][v] == 1) dfs1(v);
        }
        stack.push(u);
    }

    private static void dfs2(int u) {
        visited[u] = true;
        System.out.print(u);
        System.out.print(" ");
        for (int v = 1; v <= N; v++) {
            if (!visited[v] && reversedGraph[u][v] == 1) dfs2(v);
        }
    }

    private static int kosaraju() {
        int ans = 0;
        while (!stack.isEmpty()) stack.pop();
        Arrays.fill(visited, false);
        for (int u = 1; u <= N; u++) {
            if (!visited[u]) dfs1(u);
        }
        Arrays.fill(visited, false);
        while (!stack.isEmpty()) {
            int u = stack.peek();
            stack.pop();
            System.out.print("{");
            if (!visited[u]) {
                ans++;
                dfs2(u);
            }
            System.out.println("}");
        }
        return ans;
    }
}
