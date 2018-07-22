package interview.pinduoduo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Online3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int s = in.nextInt();
            System.out.println(minSteps(s));
        }
    }

    private static int minSteps(int target) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> next = new HashSet<>();
        int n = 0;
        q.offer(0);
        while (!q.isEmpty()) {
            while (!q.isEmpty()) {
                int cur = q.poll();
                if (cur == target || -cur == target) return n - 1;
                next.add(cur + n);
                if (n > 1) next.add(cur - n);
            }
            n++;
            for (int num : next) q.offer(num);
            next.clear();
        }
        return -1;
    }

    private static int minStepMath(int target) {
        if(target==0) return 0;
        else {
            for(long i=1;i/2-100<target;i++) {
                long sum = i*(i+1)/2;
                if(((sum+target)%2==0) && ((sum-target)%2==0) && ((sum+target)/2>=0) && ((sum+target)/2<=sum) && ((sum-target)/2>=0) && ((sum-target)/2<=sum)) {
                    return (int)i;
                }
            }
        }
        return -1;
    }
}
