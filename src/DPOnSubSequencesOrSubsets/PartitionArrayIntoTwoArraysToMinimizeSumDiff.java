package DPOnSubSequencesOrSubsets;

public class PartitionArrayIntoTwoArraysToMinimizeSumDiff {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4};

        int totalSum = 0;
        for(int i: arr){
            totalSum += i;
        }

        int minimum = findMinAbsDiff(arr, arr.length, totalSum);
        System.out.println(minimum);
    }

    public static int findMinAbsDiff(int[] arr, int n, int k){

        boolean[][]dp = new boolean[n][k+1];


        for(int i=0; i<=k; i++){
            dp[0][i] = (i==arr[0]);
        }

        // Fill in the DP table using bottom-up dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <=k; target++) {
                // Calculate if the current element is not taken
                boolean notTaken = dp[ind - 1][target];

                // Calculate if the current element is taken
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }

                // Update the DP table for the current element and target sum
                dp[ind][target] = notTaken || taken;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<=k; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        int mini = Integer.MAX_VALUE;

        for(int i=0; i<=k/2; i++){

            if(dp[n-1][i]){
                int diff = Math.abs(i - (k - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }
}
