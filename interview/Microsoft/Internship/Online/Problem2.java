package interview.Microsoft.Internship.Online;

import java.util.LinkedList;

public class Problem2 {
    public static void main(String[] args) {
        int[] a = {2, 6, 9, 8};
        LinkedList<Integer> heights = new LinkedList<>();
        for (int n : a) heights.addLast(n);
        System.out.println(days(heights));
    }

    private static int days(LinkedList<Integer> heights) {
        LinkedList<Integer> left = new LinkedList<>(), toPop = new LinkedList<>();
        int days = 0;
        while (true) {
            left.clear(); toPop.clear();
            for (int i = 0; i < heights.size(); i++) {
                if (left.isEmpty()) left.addLast(i);
                else if (heights.get(i) > (toPop.isEmpty() ? heights.get(left.getLast()) : Math.max(heights.get(left.getLast()), heights.get(toPop.getLast())))) {
                    toPop.addLast(i);
                } else left.addLast(i);
            }
            if (toPop.isEmpty()) break;
            ++days;
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int index : left) tmp.addLast(heights.get(index));
            heights = tmp;
        }
        return days;
    }
}
