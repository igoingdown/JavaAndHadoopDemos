package CCI150;

public class ShuffleCards {
    public static void main(String[] args) {
        int[] cards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        shuffleRecursively(cards, cards.length - 1);
        for (int card : cards) System.out.print(card + " ");
        System.out.println();
        shuffleIteratively(cards);
        for (int card : cards) System.out.print(card + " ");
        System.out.println();
    }

    public static int rand(int low, int high) {
        return low + (int)Math.random() * (high - low + 1);
    }
    // 洗牌算法核心思想：将更少的牌洗好，随机选取一张与当前牌进行交换
    // 洗牌算法迭代实现
    public static void shuffleIteratively(int[] cards) {
        for (int i = 0; i < cards.length; i++) {
            int k = rand(0, i);
            int tmp = cards[k]; cards[k] = cards[i]; cards[i] = tmp;
        }
    }

    // 洗牌算法递归实现
    public static void shuffleRecursively(int[] cards, int i) {
        if (i == 0) return;
        shuffleRecursively(cards, i - 1);
        int k = rand(0, i - 1);
        int tmp = cards[k]; cards[k] =cards[i]; cards[i] = tmp;
    }
}
