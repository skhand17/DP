package DPOnSubSequencesOrSubsets.Practice;

import java.util.Arrays;

public class SubSetSumEqToTarget {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4};
        int target = 3;
        int[][] dp = new int[arr.length][target + 1];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        boolean ans = subsetSum(arr, arr.length - 1, target, dp);
        System.out.println(ans);

    }

    public static boolean subsetSum(int[] arr, int index, int target, int[][] dp) {

//        base condition
        if(target == 0)
            return true;

        if(index == 0)
            return arr[index] == target;

        if(dp[index][target] != -1)
            return dp[index][target] == 1 ? true : false;

        boolean notTake = subsetSum(arr, index - 1, target, dp);
        boolean take = false;

        if(arr[index] <= target){
            take = subsetSum(arr, index - 1, target - arr[index], dp);
        }
        dp[index][target] =  notTake | take ? 1 : 0;
        return notTake | take;
    }
}
