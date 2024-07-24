package DPOnSubSequencesOrSubsets.Practice;

import java.util.Arrays;

public class SubsetSumEqualToTarget {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        int target = 3;
        int[][] dp = new int[arr.length][target+1];
        for(int[]row :dp){
            Arrays.fill(row, -1);
        }

        boolean isTrue = isSubSetSumEqualToTarget(arr, arr.length - 1, target,dp);
        System.out.println(isTrue);
    }

    public static boolean isSubSetSumEqualToTarget(int[] arr, int index, int target, int[][]dp) {

        if(target == 0)
            return true;

        if(index == 0)
            return arr[index] == target;

        if(dp[index][target] != -1){
            return dp[index][target] == 0 ? false : true;
        }

        boolean notTake = isSubSetSumEqualToTarget(arr, index - 1, target, dp);
        boolean take = false;

        if(arr[index] <= target){
            take = isSubSetSumEqualToTarget(arr, index - 1, target - arr[index], dp);
        }

         dp[index][target] = take || notTake ? 1 : 0;

        return take || notTake;

    }
}
