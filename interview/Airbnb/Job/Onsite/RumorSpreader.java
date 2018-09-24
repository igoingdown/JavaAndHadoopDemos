package interview.Airbnb.Job.Onsite;


import java.util.*;

public class RumorSpreader {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] NM = in.nextLine().split(" ");
            int N = Integer.parseInt(NM[0]), M = Integer.parseInt(NM[1]);
            Map<Integer, Set<Integer>> graph = new HashMap<>();
            for (int i = 1; i <= N; i++) graph.put(i, new HashSet<>());
            for (int i = 0; i < M; i++) {
                String[] UV = in.nextLine().split(" ");
                int u = Integer.parseInt(UV[0]), v = Integer.parseInt(UV[1]);
                graph.get(u).add(v);
            }
            Set<Integer> res = new HashSet<>(), visited = new HashSet<>();
            for (int i = 1; i <= N; i++) {
                if (!visited.contains(i)) {
                    res.add(i);
                    visited.add(i);
                    dfs(res, graph, i, i, visited, new HashSet<>());
                }
            }
            for (int i : res) System.out.println(i);
        }
    }

    private static void dfs(Set<Integer> res, Map<Integer, Set<Integer>> graph, int cur, int start, Set<Integer> visited, Set<Integer> curVisited) {
        curVisited.add(cur);
        visited.add(cur);
        for (int next : graph.get(cur)) {
            if (res.contains(next) && next != start) res.remove(next);
            if (!curVisited.contains(next)) dfs(res, graph, next, start, visited, curVisited);
        }
    }
}
