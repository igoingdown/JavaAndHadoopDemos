package go_valley_class_problems;

public class CountRepetitions {
    public static void main(String[] args) {
    System.out.println(countRepetitions("abacb", 2, "bcaa", 2));
    }

    public static int countRepetitions(String s1, int n1, String s2, int n2) {
        int[] repeatCount = new int[n1 + 1], index = new int[s2.length() + 1];
        int j = 0, count = 0;
        for (int k = 0; k < n1; k++) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    j++;
                }
                if (j == s2.length()) {
                    j = 0;
                    count++;
                }
            }
            repeatCount[k] = count;
            index[k] = j;
            for (int start = 0; start < k; start++) {
                if (index[start] == index[k]) {
                    int interval = k - start;
                    int repeat = (n1 - start) / interval;
                    int patternCount = (repeatCount[k] - repeatCount[start]) * repeat;
                    int remaining = repeatCount[start + (n1 - start) % repeat];
                    return (patternCount + remaining) / n2;
                }
            }
        }
        return repeatCount[n1] / n2;
    }
}
