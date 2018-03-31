package CCI150;

import java.util.Scanner;
import java.util.Stack;

public class StackSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) stack.push(in.nextInt());
        sort();
        while (!stack.isEmpty()) System.out.println(stack.pop());
    }

    public static void sort() {
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!buffer.isEmpty() && buffer.peek() < cur) stack.push(buffer.pop());
            buffer.push(cur);
        }
        System.out.println();
        while (!buffer.isEmpty()) stack.push(buffer.pop());
    }

    private static Stack<Integer> stack = new Stack<>();
    private static Stack<Integer> buffer = new Stack<>();
}
