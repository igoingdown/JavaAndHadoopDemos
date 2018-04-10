package CCI150;

import java.util.*;

public class StringArraySort {
    public static void main (String[] args) {
        String[] strs = {"acre", "race", "ace"};
        sortStringArrayBucket(strs);
        for (String s : strs) System.out.print(s + " ");
        System.out.println();
        String[] astrs = {"upt", "put", "aaa"};
        sortStringArray(astrs);
        for (String s : astrs) System.out.print(s + " ");
        System.out.println();
    }

    // 普通排序
    public static void sortStringArray(String[] strings) {
        Arrays.sort(strings, (String o1, String o2) -> {
                int[] key1 = new int[256], key2 = new int[256];
                for (char c : o1.toCharArray()) key1[c]++;
                for (char c : o2.toCharArray()) key2[c]++;
                return Arrays.equals(key1, key2) ? 0 : o1.compareTo(o2);
        });
    }

    // 基于桶排序
    public static void sortStringArrayBucket(String[] strings) {
        HashMap<String, List<String>> buckets = new HashMap<>();
        for (String s : strings) {
            String key = sortChars(s);
            if (!buckets.containsKey(key)) buckets.put(key, new LinkedList<>());
            buckets.get(key).add(s);
        }
        List<String> res = new ArrayList<>();
        for (String key : buckets.keySet()) res.addAll(buckets.get(key));
        for (int i = 0; i < res.size(); i++) strings[i] = res.get(i);
    }

    public static String sortChars(String s) {
        int[] freq = new int[256];
        for (char c : s.toCharArray()) freq[c]++;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c = 0; c < 256; c++) {
            while (freq[c] > 0) {
                stringBuilder.append(c); freq[c]--;
            }
        }
        return stringBuilder.toString();
    }
}
