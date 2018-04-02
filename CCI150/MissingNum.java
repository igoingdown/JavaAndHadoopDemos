package CCI150;

import java.util.ArrayList;


public class MissingNum {
    public static void main(String[] args) {

    }

    public int findMissing(ArrayList<BitInteger> nums) {
        return findMissing(nums, 0);
    }

    public static int findMissing(ArrayList<BitInteger> nums, int col) {
        if (col >= BitInteger.NUM_SIZE) return 0;
        ArrayList<BitInteger> ones = new ArrayList<>();
        ArrayList<BitInteger> zeros = new ArrayList<>();
        for (BitInteger num : nums) {
            if (num.fetch(col)) ones.add(num);
            else zeros.add(num);
        }
        if (ones.size() >= zeros.size()) return findMissing(zeros, col + 1) << 1;
        else return (findMissing(ones, col + 1) << 1) | 1;
    }
}
