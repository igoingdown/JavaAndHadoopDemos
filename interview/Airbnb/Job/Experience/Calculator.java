package interview.Airbnb.Job.Experience;

import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            System.out.println(calculate(in.nextLine()));
        }
    }

    private static int calculate(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ')') stack.push(str.charAt(i));
            else {
                StringBuilder builder = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    builder.append(stack.peek());
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                Integer ans = solve(builder.reverse().toString());
                for (char c : ans.toString().toCharArray()) stack.push(c);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.peek());
            stack.pop();
        }
        return solve(builder.reverse().toString());
    }

    private static int solve(String expr) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) != ' ') buffer.append(expr.charAt(i));
        }
        expr = buffer.toString();
        int ans = 0, lastAdd = 0, b = 0, e = 0;
        while (b < expr.length()) {
            while (e < expr.length() && expr.charAt(e) <='9' && expr.charAt(e) >= '0') e++;
            int num = Integer.parseInt(expr.substring(b, e));
            if (b == 0) {
                ans += num;
                lastAdd = num;
            } else {
                if (expr.charAt(b - 1) == '-') {
                    lastAdd = num * -1;
                    ans += lastAdd;
                } else if (expr.charAt(b - 1) == '*') {
                    ans -= lastAdd;
                    lastAdd *= num;
                    ans += lastAdd;
                } else if (expr.charAt(b - 1) == '/') {
                    ans -= lastAdd;
                    lastAdd /= num;
                    ans += lastAdd;
                } else {
                    lastAdd = num;
                    ans += lastAdd;
                }
            }
            e++;
            b = e;
        }
        return ans;
    }
}
