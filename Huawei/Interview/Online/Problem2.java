package Huawei.Interview.Online;

import java.util.*;

public class Problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            int res = 0;
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ')') stack.push(i);
                else {
                    if (str.charAt(stack.peek()) == '(') {
                        stack.pop();
                        if (stack.isEmpty()) stack.push(i);
                        else res = Math.max(res, i - stack.peek());
                    } else stack.push(i);
                }
            }
            System.out.println(res);
        }
    }
}
