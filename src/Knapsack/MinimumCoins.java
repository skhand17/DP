package Knapsack;

import java.util.Arrays;

public class MinimumCoins {

    public static void main(String[] args) {

        int[] denominations = new int[]{9, 6, 5, 1};
        int target = 11;
        int minCoins = minimumCoin(denominations, denominations.length - 1, target);
        System.out.println(minCoins);

        int[][]dp = new int[denominations.length][target + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int minCoinsMemo = minimumCoinMemo(denominations, denominations.length - 1, target, dp);
        System.out.println(minCoinsMemo);
    }

    public static int minimumCoin(int[] denominations, int index, int target) {

        if (index == 0) {
            if (target % denominations[index] == 0) {
                return target / denominations[index];
            } else
                return (int) Math.pow(10, 9);
        }

        int notTake = minimumCoin(denominations, index - 1, target);
        int take = Integer.MAX_VALUE;
        if (denominations[index] <= target) {
            take = 1 + minimumCoin(denominations, index, target - denominations[index]);
        }

        return Math.min(notTake, take);
    }

    public static int minimumCoinMemo(int[] denominations, int index, int target, int[][] dp) {

        if (index == 0) {
            if (target % denominations[index] == 0) {
                return target / denominations[index];
            } else
                return (int) Math.pow(10, 9);
        }

        if(dp[index][target] != -1)
            return dp[index][target];

        int notTake = minimumCoinMemo(denominations, index - 1, target, dp);
        int take = Integer.MAX_VALUE;
        if (denominations[index] <= target) {
            take = 1 + minimumCoinMemo(denominations, index, target - denominations[index], dp);
        }

        return dp[index][target] = Math.min(notTake, take);
    }
}
