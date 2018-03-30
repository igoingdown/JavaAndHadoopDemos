package CCI150;

public class ThreeStackInOneArrayFixedPartition {
    private int stackSize = 100;
    private int[] buffer = new int[stackSize * 3];
    private int[] pointers = {-1, -1, -1};
    public void push(int num, int x) throws Exception{
        if (pointers[num] + 1 == stackSize) throw new Exception("stack " + num + "filled!");
        ++pointers[num];
        buffer[num * stackSize + pointers[num]] = x;
    }
    public int pop(int num) throws Exception {
        if (pointers[num] == -1) throw new Exception("stakc " + num + " is empty!");
        int res = buffer[num * stackSize + pointers[num]];
        --pointers[num];
        return res;
    }

}
