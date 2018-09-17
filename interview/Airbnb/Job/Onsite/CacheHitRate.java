package interview.Airbnb.Job.Onsite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CacheHitRate {
    public static void main(String[] args) {
//         0-req-ok-x-get
//         0-resp-ok-_-get
//         1-req-ok-_-getk
//         1-resp-ok-y-getk
//         1-resp-ok-z-getk
//         1-resp-fail-w-getk
        Scanner in = new Scanner(System.in);
        HashMap<String, List<Integer>> map = new HashMap<>();
        String lastReqKey = "";
        int n = Integer.parseInt(in.nextLine());
        for (int line_num = 0; line_num < n; line_num++) {
            String[] record = in.nextLine().split("\t");
            if (record[1].equals("req") && record[2].equals("ok") && record[4].equals("get")) {
                lastReqKey = record[3];
                if (!map.containsKey(lastReqKey)) {
                    map.put(lastReqKey, new ArrayList<>());
                    map.get(lastReqKey).add(0);
                    map.get(lastReqKey).add(0);
                }
                map.get(lastReqKey).set(1, map.get(lastReqKey).get(1) + 1);
            }
            if (record[1].equals("resp")) {
                if (record[4].equals("get")) {
                    if (record[2].equals("ok")) {
                        map.get(lastReqKey).set(0, map.get(lastReqKey).get(0) + 1);
                    }
                } else {
                    if (!map.containsKey(record[3])) {
                        map.put(record[3], new ArrayList<>());
                        map.get(record[3]).add(0);
                        map.get(record[3]).add(0);
                    }
                    map.get(record[3]).set(1, map.get(record[3]).get(1) + 1);
                    if (record[2].equals("ok")) map.get(record[3]).set(0, map.get(record[3]).get(0) + 1);
                }
            }
        }
        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key).get(0) / (0.0 + map.get(key).get(1)));
        }
    }

}
