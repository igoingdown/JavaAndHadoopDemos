package CCI150;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class BoxStack {
    public static void main(String[] args) {
        Box[] boxes = {new Box(1, 3, 2), new Box(1, 2, 2), new Box(2,1, 3)};
        System.out.println(getMaxDepth(boxes));
    }

    public static class Box {
        public int width, height, depth;
        public Box(int x) {
            width = x; height = x; depth = x;
        }

        public Box(int w, int h, int d) {
            width = w; height = h; depth = d;
        }
    }

    public static int getMaxDepth(Box[] boxes) {
        Arrays.sort(boxes, new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                if (o1.width != o2.width) return Integer.compare(o1.width, o2.width);
                else if (o1.height != o2.height) return Integer.compare(o1.height, o2.height);
                else return Integer.compare(o1.depth, o2.depth);
            }
        });
        HashMap<Integer, Integer> memo = new HashMap<>();
        return dfs(boxes, 0, -1, memo);
    }

    public static int dfs(Box[] boxes, int start, int pre, HashMap<Integer, Integer> memo) {
        if (start >= boxes.length) return 0;
        if (memo.containsKey(start)) return memo.get(start);
        int res = 0;
        for (int i = start; i < boxes.length; i++) {
            if (pre == -1 || (boxes[pre].height < boxes[i].height && boxes[pre].width < boxes[i].width && boxes[pre].depth < boxes[i].depth)) res = Math.max(dfs(boxes, i + 1, i, memo) + boxes[i].height, res);
        }
        memo.put(start, res);
        return res;
    }
}
