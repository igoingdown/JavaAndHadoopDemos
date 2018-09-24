package interview.Airbnb.Job.Experience;

import java.util.*;

public class Pagination {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            List<String> hosts = new LinkedList<>();
            int pageNum = Integer.parseInt(in.nextLine()), n = Integer.parseInt(in.nextLine());
            for (int i = 0; i < n; i++) hosts.add(in.nextLine());
            for (String host : display(hosts, pageNum)) System.out.println(host);
        }
    }

    private static List<String> display(List<String> hosts, int pageNum) {
        List<String> res = new LinkedList<>();
        boolean reachEnd = false;
        HashSet<String> visited = new HashSet<>();
        Iterator<String> iter = hosts.iterator();
        int counter = 0;
        while (iter.hasNext()) {
            String host = iter.next();
            String hostID = host.split(",")[0];
            if (!visited.contains(hostID) || reachEnd) {
                res.add(host);
                visited.add(hostID);
                iter.remove();
                counter += 1;
            }
            if (counter == pageNum) {
                visited.clear();
                res.add("\n");
                iter = hosts.iterator();
                reachEnd = false;
                counter = 0;
            }
            if (!iter.hasNext()) {
                reachEnd = true;
                iter = hosts.iterator();
            }
        }
        return res;
    }
}
