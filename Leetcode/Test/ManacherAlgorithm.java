package Leetcode.Test;

import java.util.Arrays;
import java.util.Scanner;

public class ManacherAlgorithm {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String line = in.nextLine();
            System.out.println(longestParlindrome(line));
            System.out.println(totoalParlindromes(line));
        }
    }

    private static int totoalParlindromes(String str) {
        int n = str.length();
        StringBuffer buffer = new StringBuffer(n * 2 + 1);
        for (int i = 0; i < n * 2 + 1; i++) {
            if ((i & 1) == 0) buffer.append('#');
            else buffer.append(str.charAt(i / 2));
        }
        int result = 0;
        int[] maxLen = new int[n * 2+ 1];
        Arrays.fill(maxLen, 0);
        int ID = 0, maxPos = 0;
        for (int i = 0 ; i < n * 2 + 1; i++) {
            maxLen[i] = maxPos > i ? Math.min(maxPos - i, maxLen[2 * ID - i]) : 1;
            while (maxLen[i] + i < n * 2 + 1 && i >= maxLen[i] && buffer.charAt(maxLen[i] + i) == buffer.charAt(i - maxLen[i])) maxLen[i]++;
            if (maxLen[i] + i > maxPos) {
                maxPos = maxLen[i] + i;
                ID = i;
            }
            result += buffer.charAt(i) == '#' ? (maxLen[i] >> 1) : ((1 + maxLen[i]) >> 1);
        }
        return result;
    }

    private static int longestParlindrome(String str) {
        int n = str.length();
        StringBuffer buffer = new StringBuffer(n * 2 + 1);
        for (int i = 0; i < n * 2 + 1; i++) {
            if ((i & 1) == 0) buffer.append('#');
            else buffer.append(str.charAt(i / 2));
        }
        int result = 0;
        int[] maxLen = new int[n * 2+ 1];
        Arrays.fill(maxLen, 0);
        int ID = 0, maxPos = 0;
        for (int i = 0 ; i < n * 2 + 1; i++) {
            maxLen[i] = maxPos > i ? Math.min(maxPos - i, maxLen[2 * ID - i]) : 1;
            while (maxLen[i] + i < n * 2 + 1 && i >= maxLen[i] && buffer.charAt(maxLen[i] + i) == buffer.charAt(i - maxLen[i])) maxLen[i]++;
            if (maxLen[i] + i > maxPos) {
                maxPos = maxLen[i] + i;
                ID = i;
            }
            result = Math.max(result, maxLen[i] - 1);
        }
        return result;
    }
}
