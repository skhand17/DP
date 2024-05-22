package Knapsack;


import java.util.Arrays;

/*
 *
 * Classic Example of 0/1 Knapsack problem
 *
 * */
public class KnapsackZeroOne {

    public static void main(String[] args) {

        int[] prices = new int[]{80, 110, 60};
        int[] weight = new int[]{3, 2, 4};

        int W = 6;

        int maximumPrice = maxPrice(prices, weight, prices.length - 1, W);
        System.out.println(maximumPrice);

        int[][] dp = new int[prices.length][W + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        int maxPriceMemo = maxPriceMemo(prices, weight, prices.length - 1, W, dp);
        System.out.println(maxPriceMemo);

        int maxPriceTab = maxPriceTab(prices, weight, prices.length, W);
        System.out.println(maxPriceTab);
    }

    public static int maxPrice(int[] prices, int[] weight, int index, int W) {

        if (index == 0) {

            if (weight[index] <= W) {
                return prices[index];
            } else
                return 0;
        }
        int notTake = maxPrice(prices, weight, index - 1, W);

        int take = Integer.MIN_VALUE;
        if (weight[index] <= W) {
            take = prices[index] + maxPrice(prices, weight, index - 1, W - weight[index]);
        }

        return Math.max(notTake, take);

    }

    public static int maxPriceMemo(int[] prices, int[] weight, int index, int W, int[][] dp) {

        if (index == 0) {

            if (weight[index] <= W) {
                return prices[index];
            } else
                return 0;
        }

        if (dp[index][W] != -1)
            return dp[index][W];

        int notTake = maxPrice(prices, weight, index - 1, W);

        int take = Integer.MIN_VALUE;
        if (weight[index] <= W) {
            take = prices[index] + maxPrice(prices, weight, index - 1, W - weight[index]);
        }

        return dp[index][W] = Math.max(notTake, take);

    }

    /*
    *      0  1  2  3  4  5  6  7  8  9  10
   +-------------------------------
0  | 0  0  0  2  2  2  2  2  2  2  2
1  | 0
2  | 0
3  | 0
    *
    * */
    public static int maxPriceTab(int[] prices, int[] weight, int index, int W) {

        int[][] dp = new int[index][W + 1];

//      Base Condition of Recursion
        for (int i = weight[0]; i <= W; i++)
            dp[0][i] = prices[0];

        for (int ind = 1; ind < index; ind++) {
            for (int cap = 0; cap <= W; cap++) {

                int notTake = dp[ind - 1][cap];
                int take = Integer.MIN_VALUE;

                if (weight[ind] <= cap) {
                    take = prices[ind] + dp[ind - 1][cap - weight[ind]];
                }

                dp[ind][cap] = Math.max(notTake, take);
            }
        }
        return dp[index - 1][W];
    }

}
