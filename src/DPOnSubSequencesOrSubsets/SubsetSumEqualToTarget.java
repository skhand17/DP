package DPOnSubSequencesOrSubsets;

import java.util.Arrays;

public class SubsetSumEqualToTarget {

    public static void main(String[] args) {

        int[]arr = new int[]{3, 34, 4, 12, 5, 2};

        int target = 30;
        int[][]dp = new int[arr.length][target+1];

        for(int[] row : dp)
            Arrays.fill(row, -1);

        boolean ans = subSetSum(arr, arr.length - 1, target, dp);
        System.out.println(ans);


        boolean ansTab = subSetSumTab(arr, arr.length, target);
        System.out.println(ansTab);
    }

    public static boolean subSetSum(int[] arr, int index, int target, int[][] dp){

        if(target == 0)
            return true;

        if(index == 0)
            return arr[index] == target;

        if(dp[index][target] != -1)
            return dp[index][target] == 0 ? false : true;

        boolean notTake = subSetSum(arr, index-1, target, dp);
        boolean take = false;

        if(target >= arr[index]){
            take = subSetSum(arr, index - 1, target - arr[index], dp);
        }

        dp[index][target] = notTake || take ? 1: 0;
        return notTake || take;
    }

    public static boolean subSetSumTab(int[] arr, int n, int k) {

        boolean[][]dp = new boolean[n][k+1];

        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }

        if(arr[0] <=k){
            dp[0][arr[0]] = true;
        }

        for(int ind = 1; ind <n; ind++){
            for(int target = 1; target <=k; target++){
                boolean notTaken = dp[ind-1][target];

                boolean taken = false;
                if(target >= arr[ind]){
                    taken = dp[ind-1][target- arr[ind]];
                }

                dp[ind][target] = notTaken || taken;
            }
        }
        return dp[n-1][k];
    }
}
