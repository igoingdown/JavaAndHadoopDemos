package CCI150;

public class RandomizedCollectionTest {
    public static void main(String[] args) {
        RandomizeCollection c = new RandomizeCollection();
        c.insert(0);
        c.remove(0);
        c.insert(-1);
        c.remove(0);
        c.getRandom();
        c.getRandom();
    }
}
