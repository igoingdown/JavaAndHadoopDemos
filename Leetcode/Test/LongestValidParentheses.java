package Leetcode.Test;

import java.util.Scanner;
import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            System.out.println(longestValidParentheses(str));
            System.out.println(longestValidParenthesesTP(str));
        }
    }

    private static int longestValidParentheses(String str) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else res = Math.max(res, i - stack.peek());
            }
        }
        return res;
    }

    private static int longestValidParenthesesTP(String str) {
        int n = str.length(), res = 0, left = 0, right = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') left++;
            else right++;
            if (left == right) res = Math.max(res, (right << 1));
            else if (right > left) left = right = 0;
        }
        left = right = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == '(') left++;
            else right++;
            if (left == right) res = Math.max(res, (left << 1));
            else if (left > right) left = right = 0;
        }
        return res;
    }
}
