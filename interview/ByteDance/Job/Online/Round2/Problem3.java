package interview.ByteDance.Job.Online.Round2;

import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int caseNum = Integer.parseInt(in.nextLine());
        for (int i = 0; i < caseNum; i++) {
            HashMap<String, List<String>> groups = new HashMap<>();
            int wordNum = Integer.parseInt(in.nextLine());
            for (int j = 0; j < wordNum; j++) {
                String word = in.nextLine();
                char[] arr = word.toCharArray();
                Arrays.sort(arr);
                String sorted = new String(arr);
                if (!groups.containsKey(sorted)) groups.put(sorted, new LinkedList<>());
                groups.get(sorted).add(word);
            }

            boolean caseRes = false;
            for (String key: groups.keySet()) {
                String[] group = new String[groups.get(key).size()];
                groups.get(key).toArray(group);
                for (int m = 0; m < group.length; m++) {
                    for (int j = m + 1; j < group.length; j++) {
                        String forward = group[m];
                        for (int start = 0; start < key.length(); start++) {
                            if (forward.substring(start, start + key.length()).equals(group[j])) {
                                caseRes = true;
                                break;
                            }
                        }
                        if (caseRes) break;
                        StringBuilder buffer1 = new StringBuilder(group[m]);
                        buffer1.reverse();
                        String reversedStr = buffer1.toString();
                        buffer1.append(reversedStr);
                        String backward = buffer1.toString();
                        for (int start = 0; start < key.length(); start++) {
                            if (backward.substring(start, start + key.length()).equals(group[j])) {
                                caseRes = true;
                                break;
                            }
                        }
                        if (caseRes) break;
                    }
                    if (caseRes) break;
                }
                if (caseRes) break;
            }
            System.out.println(caseRes ? "Yeah" : "Sad");
        }
    }
}
