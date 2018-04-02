package CCI150;

public class BitInteger {
    public static final int NUM_SIZE = 32;
    private boolean[] bits;
    public BitInteger() {
        bits = new boolean[NUM_SIZE];
    }
    public boolean fetch(int col) {
        return bits[col];
    }
}
