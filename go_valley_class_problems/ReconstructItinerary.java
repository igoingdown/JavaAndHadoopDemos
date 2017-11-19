package go_valley_class_problems;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.List;

public class ReconstructItinerary {
    private static HashMap<String, PriorityQueue<String>> m = new HashMap<>();
    private static LinkedList<String> res = new LinkedList<>();

    public static void main(String[] args) {
        // String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","JFK"}};
        List<String> res = findItinerary(tickets);
        for (String s: res) System.out.println(s);
    }

    private static List<String> findItinerary(String[][] tickets) {
        for (String[] pair : tickets) {
            m.putIfAbsent(pair[0], new PriorityQueue<>());
            m.get(pair[0]).add(pair[1]);
        }
        dfs("JFK");
        return res;
    }

    private static void dfs(String departure) {
        PriorityQueue<String> arrivals = m.get(departure);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll());
        }
        res.addFirst(departure);
    }
}
