package DPOnSubSequencesOrSubsets;

import java.util.Arrays;

public class PartionEqualSubsetSum {
    public static void main(String[] args) {

        int[] arr = new int[]{2, 3, 3, 3, 4, 5};
        int sum = 0;

        for(int i: arr){
            sum += i;
        }

        int[][]dp = new int[arr.length][sum/2 + 1];
        for(int[]row : dp)
            Arrays.fill(row, -1);

        boolean isTrue = partitionEqualSubSetSum(arr, arr.length - 1, sum/2);
        System.out.println(isTrue);

        boolean isTrueMemo = partitionEqualSubSetSumMemo(arr, arr.length - 1, sum/2, dp);
        System.out.println(isTrueMemo);


    }

    public static boolean partitionEqualSubSetSum(int []arr, int index, int target) {

        if(target == 0)
            return true;

        if(index == 0){
            return arr[index] == target;
        }

        boolean notTake = partitionEqualSubSetSum(arr, index - 1, target);
        boolean take = false;

        if(target >= arr[index]){
            take = partitionEqualSubSetSum(arr, index - 1, target - arr[index]);
        }

        return notTake || take;
    }

    public static boolean partitionEqualSubSetSumMemo(int[] arr, int index, int target, int[][] dp) {

        if(target == 0)
            return true;

        if(index == 0){
            return arr[index] == target;
        }

        if(dp[index][target] != -1){
            return dp[index][target] == 0 ? false : true;
        }

        //  not take
        boolean notTake = partitionEqualSubSetSumMemo(arr, index - 1, target,dp);
        //  take
        boolean take = false;

        if(target >= arr[index]) {
            take = partitionEqualSubSetSumMemo(arr, index - 1, target - arr[index], dp);
        }

        dp[index][target] = notTake || take ? 1 : 0;
        return take || notTake;

    }
}
