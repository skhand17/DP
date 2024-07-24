package DPOnStocks.Practice;

import java.util.Arrays;

public class BestTimeIV {
        public static void main(String[] args) {
            int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
            int k = 3;
            int[][][] dp = new int[prices.length][2][k+1];
            for(int i=0; i<prices.length; i++){
                for(int j=0; j<2; j++){
                    Arrays.fill(dp[i][j], -1);
                }
            }


            int result = bestTimeBuyAndSellStock(prices, 0, 1,3 , dp);
            System.out.println(result);

        }

        public static int bestTimeBuyAndSellStock(int[] prices, int index, int buy,
                                                  int transactions, int[][][] dp) {

            if (index >= prices.length) {
                return 0;
            }
            if (transactions == 0) {
                return 0;
            }

            if(dp[index][buy][transactions] != -1){
                return dp[index][buy][transactions];
            }

            int profit;

            if (buy == 1) {
                profit = Math.max(-prices[index] + bestTimeBuyAndSellStock(prices, index + 1, 0, transactions, dp),
                        bestTimeBuyAndSellStock(prices, index + 1, 1, transactions, dp));
            } else {
                profit = Math.max(prices[index] + bestTimeBuyAndSellStock(prices, index + 1, 1, transactions-1, dp) ,
                        bestTimeBuyAndSellStock(prices, index+1, 0, transactions, dp));
            }

            return dp[index][buy][transactions] = profit;

        }
    }

