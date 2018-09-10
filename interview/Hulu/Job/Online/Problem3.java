package interview.Hulu.Job.Online;

import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] items = in.nextLine().split(" ");
        int m = Integer.parseInt(items[0]), n = Integer.parseInt(items[1]), k = Integer.parseInt(items[2]);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int[] rd = new int[m];
        List<List<Integer>> w = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            w.add(new ArrayList<>());
        }
        for(int i = 0; i < k; i++) {
            String[] dependency = in.nextLine().split(" ");
            int a = Integer.parseInt(dependency[0]), b = Integer.parseInt(dependency[1]);
            w.get(b - 1).add(a - 1);
            rd[a - 1] += 1;
        }
        int ans = 1, res = m;
        for(int i = 0; i < m; i++) {
            if(rd[i] == 0) {
                q.offer(i);
                res--;
            }
        }
        while(res != 0) {
            List<Integer> tomorrow = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                if(q.isEmpty()) {
                    break;
                }
                int now = q.peek();
                for(int j = 0; j < w.get(now).size(); j++) {
                    rd[w.get(now).get(j)]--;
                    if(rd[w.get(now).get(j)] == 0) {
                        tomorrow.add(w.get(now).get(j));
                    }
                }
                q.poll();
            }
            ans++;
            for(int i = 0; i < tomorrow.size(); i++) {
                q.offer(tomorrow.get(i));
                res--;
            }
            if(q.isEmpty()) {
                break;
            }
        }
        if(res != 0) {
            System.out.println("E");
        }
        else {
            System.out.println(ans);
        }
    }
}

