package CCI150;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class ExpressionCalculate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            try {
                System.out.println(calculate(s));
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            System.out.println(Boolean.toString(true));
            HashMap<String, Integer> map = new HashMap<>();
            map.put("0" + " " + Boolean.toString(true), 0); map.put("1" + " " + Boolean.toString(false), 0);
            map.put("1" + " " + Boolean.toString(true), 1); map.put("0" + " " + Boolean.toString(false), 1);
            System.out.println(resWays(s, true, map) + " ways to get 1");
            System.out.println(resWays(s, false, map) + " ways to get 0");
        }
    }

    public static boolean calculate(String expression) throws Exception {
        Stack<Character> symbols = new Stack<>();
        Stack<Boolean> nums = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '1' || c == '0') {
                nums.push(c == '1');
            } else if (c == ')') {
                while (!symbols.isEmpty() && symbols.peek() != '(') {
                    boolean right = nums.pop(), left = nums.pop();
                    switch (symbols.pop()) {
                        case '|':
                            nums.push(left | right); break;
                        case '^':
                            nums.push(left ^ right); break;
                        case '&':
                            nums.push(left & right); break;
                        default: break;
                    }
                }
            } else {
                symbols.push(c);
            }
        }
        try {
            return nums.pop();
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
    }
    // 不用memo有重复计算，加入memo提高时间效率。
    public static int resWays(String expression, boolean res, HashMap<String, Integer> map) {
        if (map.containsKey(expression + " " +Boolean.toString(res))) return map.get(expression + " " + Boolean.toString(res));
        int count = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) != '1' && expression.charAt(i) != '0') {
                String a = expression.substring(0, i), b = expression.substring(i + 1);
                if (expression.charAt(i) == '&') count += res ? resWays(a, true, map) * resWays(b, true, map) : resWays(a, true, map) * resWays(b, false, map) + resWays(a, false, map) * resWays(b, true, map) + resWays(a, false, map) * resWays(b, false, map);
                else if (expression.charAt(i) == '|') count += res ? resWays(a, true, map) * resWays(b, true, map) + resWays(a, true, map) * resWays(b, false, map) + resWays(a, false, map) * resWays(b, true, map) : resWays(a, false, map) * resWays(b, false, map);
                else count += res ? resWays(a, false, map) * resWays(b, true, map) + resWays(a, true, map) * resWays(b, false, map) : resWays(a, true, map) * resWays(b, true, map) + resWays(a, false, map) * resWays(b, false, map);
            }
        }
        map.put(expression + " " +Boolean.toString(res), count);
        return count;
    }

    // 运用Catalan数优化
    public static int resWaysCatalan(String expression, boolean res, HashMap<String, Integer> map) {
        if (map.containsKey(expression + " " +Boolean.toString(res))) return map.get(expression + " " + Boolean.toString(res));
        int count = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) != '1' && expression.charAt(i) != '0') {
                String a = expression.substring(0, i), b = expression.substring(i + 1);
                int aTrue = resWaysCatalan(a, true, map), bTrue = resWaysCatalan(b, true, map);
                int aTotal = total(a.length() / 2), bTotal = total(b.length() / 2);
                int aFalse = aTotal - aTrue, bFalse = bTotal - bTrue;
                if (expression.charAt(i) == '&') count += res ? aTrue * bTrue : aTotal * bTotal - aTrue * bTrue;
                else if (expression.charAt(i) == '|') count += res ? aTotal * bTotal - aFalse * bFalse : aFalse * bFalse;
                else count += res ? aFalse * bTrue + aTrue * bFalse : aTrue * bTrue + aFalse * bFalse;
            }
        }
        map.put(expression + " " +Boolean.toString(res), count);
        return count;
    }

    // 计算卡塔兰数
    public static int total(int n) {
        if (n == 0) return 1;
        int res = 1;
        for (int i = n + 1; i <= n * 2; i++) res *= i;
        for (int i = 1; i<= n + 1; i++) res /= i;
        return res;
    }

}
