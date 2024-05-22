package DPOnStocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStocksIV {

    public static void main(String[] args) {

        int[]prices = new int[] {3, 2, 6, 5, 0, 3};
        int  k =2;

        System.out.println(maxProfit(k, prices));
    }

    public static int maxProfit(int k, int[] prices) {

        int[][][] dp = new int[prices.length][2][k + 1];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return maxProfitMaxima(prices, 0, 1, k, dp);

    }

    public static int maxProfitMaxima(int [] prices, int index, int buy, int cap, int[][][]dp) {

        if(index == prices.length)
            return 0;

        if(cap == 0)
            return 0;

        if(dp[index][buy][cap] != -1) {
            return dp[index][buy][cap];
        }

        int profit;

        if(buy == 1) {
            profit = Math.max(-prices[index] + maxProfitMaxima(prices, index + 1, 0, cap,dp),
                    maxProfitMaxima(prices, index + 1, 1, cap, dp));
        } else {
            profit = Math.max(prices[index] + maxProfitMaxima(prices, index + 1, 1, cap-1 ,dp),
                    maxProfitMaxima(prices, index + 1, 0, cap, dp));
        }

        return dp[index][buy][cap] = profit;
    }

}

