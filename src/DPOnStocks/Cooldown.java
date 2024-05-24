package DPOnStocks;

import java.util.Arrays;

public class Cooldown {

    public static void main(String[] args) {

        int []prices = new int[]{4, 9, 0, 4, 10};
        int[][] dp = new int[prices.length][2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        int maximumProfitAfterCooldown = coolDown(prices, 0, 1, dp);
        System.out.println(maximumProfitAfterCooldown);
    }


    public static int coolDown(int[] prices, int index, int buy, int[][]dp) {
        int n = prices.length;
        if(index >= n)
            return 0;

        if(dp[index][buy] != -1){
            return dp[index][buy];
        }
        int profit;
        if(buy == 1) {
            profit = Math.max(-prices[index] + coolDown(prices, index+1, 0, dp),
                                                coolDown(prices, index+1, 1, dp));
        } else {
            profit = Math.max(prices[index] + coolDown(prices, index + 2, 1, dp),
                                                coolDown(prices, index+1, 0, dp));
        }
        return dp[index][buy] = profit;
    }
}
