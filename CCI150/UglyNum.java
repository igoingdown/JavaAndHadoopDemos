package CCI150;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class UglyNum {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) System.out.print(getKthNum(i) + " ");
    }

    public static int getKthNum(int k) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        int[] indice = {0, 0, 0};
        //              0, 1, 2
        int[] bases =  {2, 3, 5};
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(3, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(nums.get(indice[o1]) * bases[o1], nums.get(indice[o2]) * bases[o2]);
            }
        });
        minHeap.add(0); minHeap.add(1); minHeap.add(2);
        while (nums.size() <= k) {
            int index = minHeap.poll();
            nums.add(nums.get(indice[index]) * bases[index]);
            while (nums.get(indice[minHeap.peek()]) * bases[minHeap.peek()] == nums.get(indice[index]) * bases[index]) {
                int cur = minHeap.poll();
                ++indice[cur]; minHeap.add(cur);
            }
            ++indice[index]; minHeap.add(index);
        }
        return nums.get(k);
    }

}
