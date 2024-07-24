package C3SubsequencesSubsets;

import java.util.Arrays;

public class MinimumCoins {
    public static void main(String[] args) {
        int[] denominations = new int[]{9, 6, 5, 1};
        int target = 11;

        int ans = coinChangeI(denominations, target);
        System.out.println(ans);

    }

    public static int coinChangeI(int[] coins, int target) {
        int[][] dp = new int[coins.length][target + 1];
        for(int[] row : dp)
            Arrays.fill(row , -1);

        if(coins.length == 1){
            if(target % coins[0] != 0)
                return -1;
        }

        int minimum = minimumCoins(coins, target, coins.length - 1, dp);
        if(minimum >= (int)1e9)
            return -1;
        return minimum;
    }

    public static int minimumCoins(int[] coins, int target, int index, int[][] dp) {

//        not sure of base condition
        if(index == 0){
            if(target % coins[index] == 0){
                return target / coins[index];
            } else {
                return (int)1e9;
            }
        }

        if(dp[index][target] != -1){
            return dp[index][target];
        }

        int notTake = minimumCoins(coins, target, index - 1, dp);
        int take = (int)1e9;
        if(target >= coins[index])
            take = 1 + minimumCoins(coins, target - coins[index] , index - 1, dp);

        return dp[index][target] = Math.min(take , notTake);
    }
}
