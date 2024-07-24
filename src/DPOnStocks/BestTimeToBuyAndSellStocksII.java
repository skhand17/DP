package DPOnStocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStocksII {

    public static void main(String[] args) {

        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
//        System.out.println(maxProfit(prices));

        System.out.println(profitMaximaTab(prices, prices.length));
//        System.out.println(profitMaximaTabSpaceOptimization(prices, prices.length));
    }
    public static int maxProfit(int[] prices) {

        int[][]dp = new int[prices.length][2];
        for(int[]row : dp){
            Arrays.fill(row, -1);
        }

        return profitMaxima(prices, 0, 1, dp);

    }

    public static int profitMaxima(int[] prices, int index, int buy, int[][]dp) {

        if(index == prices.length)
            return 0;

        if(dp[index][buy] != -1)
            return dp[index][buy];
        int profit;
        if(buy == 1){
            profit = Math.max(
                    -prices[index] + profitMaxima(prices, index + 1, 0, dp),
                    profitMaxima(prices, index+1, 1, dp));
        } else {
            profit = Math.max(prices[index] + profitMaxima(prices, index + 1, 1,dp),
                    profitMaxima(prices, index+1,0,dp));
        }
        return dp[index][buy] = profit;
    }

    public static int profitMaximaTab(int[] prices, int n) {

        int[][]dp = new int[n+1][2];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        dp[n][0] = dp[n][1] = 0;
        for(int index= n-1; index>=0; index--){
            for(int b=0; b<=1; b++){
                int profit;
                if(b == 1){
                    profit = Math.max(-prices[index] + dp[index+1][0] ,
                                            dp[index+1][1]);
                } else {
                    profit = Math.max(prices[index] + dp[index+1][1] ,
                                        dp[index+1][0]);
                }
                dp[index][b] = profit;
            }
        }

        for(int i=0; i<=n; i++){
            for(int j=0; j<=1; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[0][1];
    }
/*
* Not understood
*
* */
//    public static int profitMaximaTabSpaceOptimization(int[] prices, int n) {
//
////
//        int[] ahead = new int[2];
//        int[] cur = new int[2];
////        ahead[0] = 0;
////        cur[0] = 0;
//        int profit;
//        for(int index= n-1; index>=0; index--){
//            for(int b=0; b<=1; b++){
//                if(b == 1){
//                    profit = Math.max(-prices[index] + ahead[1] ,
//                            ahead[0]);
//                } else {
//                    profit = Math.max(prices[index] + ahead[0] ,
//                            ahead[1]);
//                }
//                cur[b] = profit;
//            }
//            ahead = cur;
//        }
//        return ahead[1];
//    }
}
