package Leetcode.Test;

import java.util.*;

public class TrappingRainWater {
    public static void main(String[] args) {
        test();
        //testThroughTerminal();
    }

    public static void test() {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappingWater(arr));
    }

    public static void testThroughTerminal() {
        Scanner in = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        while (in.hasNext()) {
            arr.add(in.nextInt());
        }
        System.out.println(trappingWater(arr.stream().mapToInt(Integer::intValue).toArray()));
    }

    public static int trappingWater(int[] arr) {
        int n = arr.length, i = 0, res = 0;
        Stack<Integer> s = new Stack<>();
        while (i < n) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                int bottom = s.peek(), top = bottom, width = 0;
                s.pop();
                if (!s.isEmpty()) {
                    top = s.peek();
                    width = i - top - 1;
                }
                res += (Math.min(arr[i], arr[top]) - arr[bottom]) * width;
            }
            s.push(i++);
        }
        return res;
    }
}
