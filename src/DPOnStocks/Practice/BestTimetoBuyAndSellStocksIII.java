package DPOnStocks.Practice;


import java.util.Arrays;

/*
 * Atmost 2 transactions
 *
 * */
public class BestTimetoBuyAndSellStocksIII {

    public static void main(String[] args) {

        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        int[][][] dp = new int[prices.length][2][3];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int maximumProfit = maximaProfit(prices, 0, 1, 2, dp);
        System.out.println(maximumProfit);
    }

    public static int maximaProfit(int[] prices, int index, int buy, int capacity, int[][][] dp) {

        if (index == prices.length)
            return 0;

        if (capacity == 0)
            return 0;

        if (dp[index][buy][capacity] != -1)
            return dp[index][buy][capacity];

        int profit;
        if (buy == 1) {
            profit = Math.max(-prices[index] + maximaProfit(prices, index + 1, 0, capacity, dp),
                    maximaProfit(prices, index + 1, 1, capacity, dp));
        } else {
            profit = Math.max(prices[index] + maximaProfit(prices, index + 1, 1,
                            capacity - 1, dp),
                    maximaProfit(prices, index + 1, 0, capacity, dp));

        }
        return dp[index][buy][capacity] = profit;


    }
}
