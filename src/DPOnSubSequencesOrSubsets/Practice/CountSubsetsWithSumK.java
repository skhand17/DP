package DPOnSubSequencesOrSubsets.Practice;

import java.util.Arrays;

public class CountSubsetsWithSumK {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 3};
        int target = 3;

        int[][]dp = new int[arr.length][target + 1];
        for(int[]row : dp){
            Arrays.fill(row, -1);
        }
        int totalCount = count(arr, arr.length - 1, target, dp);
        System.out.println(totalCount);


    }

    public static int count(int[] arr, int index, int target, int[][] dp) {

        if(target == 0)
            return 1;

        if(index  ==  0) {
            if(arr[index] == target){
                return 1;
            } else
                return 0;
        }

        if(dp[index][target] != -1){
            return dp[index][target];
        }

        int notTake = count(arr, index - 1, target,dp);
        int take = 0;

        if(arr[index] <= target){
            take = count(arr, index - 1, target - arr[index],dp);
        }

        return dp[index][target] = take + notTake;
    }
}
