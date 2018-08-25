package interview.Huawei.Job.Online;

import java.util.*;

public class Problem3 {
    // case pass rate: 50%
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) map.put(str.charAt(i), new LinkedList<>());
            map.get(str.charAt(i)).add(i);
        }
        int res = 0, start = 0;
        for (char c : map.keySet()) {
            for (int start_pos1 : map.get(c)) {
                for (int start_pos2 : map.get(c)) {
                    if (start_pos1 >= start_pos2) continue;
                    int i = 0;
                    while (start_pos1 + i < start_pos2 && start_pos2 + i < str.length() && str.charAt(start_pos1 + i) == str.charAt(start_pos2 + i)) i++;
                    if (i >= res) {
                        start = (i > res ? start_pos1 : Math.min(start, start_pos1));
                        res = i;
                    }
                }
            }
        }
        System.out.println((res == 0 ? "" : str.substring(start, start + res))+ " " + res);
    }
}
