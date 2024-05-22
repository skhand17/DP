package DPOnSubSequencesOrSubsets;

import java.util.Arrays;

public class CountSubsetsWithSumK {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 2, 3};

        int target = 3;

        int[][] dp = new int[arr.length][target+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }


        int count = countSubSets(arr, arr.length - 1, target);
        System.out.println(count);

        int countMemo = countSubSetsMemo(arr, arr.length - 1, target, dp);
        System.out.println(countMemo);
    }

    public static int countSubSets(int[] arr, int index, int target) {

        if(target == 0)
            return 1;

        if(index == 0){
            if(arr[index] == target)
                return 1;
            else
                return 0;
        }

//        Not take:
        int notTake = countSubSets(arr, index - 1, target);

        int take = 0;

        if(target >= arr[index]){
            take = countSubSets(arr, index - 1, target - arr[index]);
        }

        return notTake + take;
    }

    public static int countSubSetsMemo(int[] arr, int index, int target, int[][] dp) {

        if(target == 0)
            return 1;

        if(index == 0){
            if(arr[index] == target)
                return 1;
            else
                return 0;
        }

        if(dp[index][target] != -1)
            return dp[index][target];

//        Not take:
        int notTake = countSubSetsMemo(arr, index - 1, target, dp);

        int take = 0;

        if(target >= arr[index]){
            take = countSubSetsMemo(arr, index - 1, target - arr[index], dp);
        }

        return dp[index][take] = notTake + take;
    }


}
