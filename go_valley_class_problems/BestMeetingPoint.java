package go_valley_class_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestMeetingPoint {
    // grid中的元素表示该位置是否有人，计算所有人meet的最优位置
    // x,y分别计算，因为是不相关的两个量！
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}};
        System.out.println(minTotalDistance(grid));
    }

    private static int minTotalDistance(int[][] grid) {
        List<Integer> iPos = new ArrayList<>();
        List<Integer> jPos = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    iPos.add(i);
                    jPos.add(j);
                }
            }
        }
        Collections.sort(iPos);
        Collections.sort(jPos);
        int sum = 0;
        int start = 0, end = iPos.size() - 1;
        while (start < end) {
            sum += iPos.get(end) - iPos.get(start);
            sum += jPos.get(end) - jPos.get(start);
            end--;
            start++;
        }
        return sum;
    }
}
