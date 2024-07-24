package C3SubsequencesSubsets;

import java.util.Arrays;

class CoinChangeII {
    public int change(int amount, int[] coins) {

        int[][] dp = new int[coins.length][amount + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        int noOfWays = countWays(coins.length - 1, amount, coins, dp);
        return noOfWays;
    }

    public int countWays(int index, int target, int[] coins, int[][] dp) {

        if(index == 0) {

            if(target % coins[index] == 0){
                return 1;
            } else {
                return 0;
            }
        }

        if(dp[index][target] != -1) {
            return dp[index][target];
        }

        int notTake = countWays(index - 1, target, coins, dp);
        int take = 0;

        if(target >= coins[index]) {
            take = countWays(index, target - coins[index], coins, dp);
        }

        return dp[index][target] = notTake + take;
    }
}
