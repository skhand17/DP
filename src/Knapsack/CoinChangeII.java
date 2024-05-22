package Knapsack;

import java.util.Arrays;

public class CoinChangeII {

    public static void main(String[] args) {

        int[]arr = new int[]{1, 2, 3};
        int target = 4;

        int[][]dp = new int[arr.length][target + 1];
        for(int[]row : dp){
            Arrays.fill(row, -1);
        }

        int totalNoOfWays = totalWaysCoinChange(arr, arr.length - 1, target, dp);
        System.out.println(totalNoOfWays);
    }

    public static int totalWaysCoinChange(int[] arr, int index, int target, int[][] dp) {

//        Base case
        if(index == 0){
            if(target % arr[index] == 0){
                return 1;

            }else {
                return 0;
            }
        }
        if(dp[index][target] != -1){
            return dp[index][target];
        }

        int notTake = totalWaysCoinChange(arr, index - 1, target,dp);
        int take = 0;

        if(arr[index] <= target){
            take = totalWaysCoinChange(arr, index, target - arr[index], dp);
        }

        return dp[index][target]= take + notTake;

    }
}
