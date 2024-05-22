package DPOnStocks;

import java.util.Arrays;

public class BestTimToBuyAndSellStocksIII {

    public static void main(String[] args) {
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(prices));
        System.out.println(maximaProfitTab(prices));
    }

    public static int maxProfit(int[] prices) {
        int[][][]dp = new int[prices.length][2][3];

        for(int i=0; i<prices.length; i++) {
            for(int j=0; j<2; j++){
                Arrays.fill(dp[i][j] , -1);
            }
        }
        return maximaProfit(prices, 0, 1, 2, dp);
    }

    public static int maximaProfit(int[] prices, int index, int buy, int cap, int[][][]dp) {

        if (index == prices.length) {
            return 0;
        }

        if (cap == 0) {
            return 0;
        }

        if(dp[index][buy][cap] != -1){
            return dp[index][buy][cap];
        }

        int profit;

        if (buy == 1) {
            profit = Math.max(-prices[index] + maximaProfit(prices, index + 1, 0, cap,dp),
                                                maximaProfit(prices, index + 1, 1, cap,dp));
        } else {

            profit = Math.max(prices[index] + maximaProfit(prices, index + 1, 1, cap - 1,dp),
                                              maximaProfit(prices, index + 1, 0, cap,dp));
        }

        return dp[index][buy][cap] = profit;

    }
    public static int maximaProfitTab(int[] prices) {

        int[][][]dp = new int[prices.length + 1][2][3];
        for(int index=prices.length-1; index >=0; index--){
            for(int buy=0; buy<=1; buy++){
                for(int cap=1; cap<=2; cap++){
                    if(buy == 1){
                        dp[index][buy][cap]= Math.max(-prices[index] + dp[index+1][0][cap],
                                                                dp[index+1][1][cap]);
                    } else {
                        dp[index][buy][cap] = Math.max(prices[index] + dp[index+1][1][cap-1],
                                                            dp[index+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}
