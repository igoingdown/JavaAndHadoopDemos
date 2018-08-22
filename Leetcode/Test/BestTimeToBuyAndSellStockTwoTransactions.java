package Leetcode.Test;

public class BestTimeToBuyAndSellStockTwoTransactions {
    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        System.out.println(solve(prices));
    }

    private static int solve(int[] prices) {
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE, sell1 = 0, sell2 = 0;
        for (int price : prices) {
            sell2 = Math.max(sell2, buy2 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell1 = Math.max(sell1, buy1 + price);
            buy1 = Math.max(buy1, -price);
        }
        return sell2;
    }
}
