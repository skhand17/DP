package DPOnSubSequencesOrSubsets.Practice;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 3, 3, 4, 5, 3};
        int sum = 0;
        for(int i: arr){
            sum += i;
        }

//        if(sum % 2 != 0){
//            System.out.println(false);
//        }

        int targetSum = sum / 2;
        int[][] dp = new int[arr.length][targetSum + 1];
        for(int[]row : dp){
            Arrays.fill(row, -1);
        }

        boolean ans = isSubSetSum(arr, arr.length - 1, targetSum, dp);
        System.out.println(ans);
    }

    public static boolean isSubSetSum(int[] arr, int index, int target, int[][]dp) {

//        I don't know my base condition yet
        if(target == 0)
            return true;

        if(index == 0)
            return arr[index] == target;

        if(dp[index][target] != -1)
            return dp[index][target] == 0 ? false : true;

        boolean notTake = isSubSetSum(arr, index - 1, target, dp);
        boolean take =  false;

        if(arr[index] <= target){
            take = isSubSetSum(arr, index - 1, target - arr[index], dp);
        }

         dp[index][target] = take || notTake ? 1 : 0;
        return take || notTake;
    }
}
