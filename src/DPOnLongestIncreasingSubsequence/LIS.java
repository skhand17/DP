package DPOnLongestIncreasingSubsequence;

import java.util.Arrays;

public class LIS {

    public static void main(String[] args) {

        int[] arr = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int n = arr.length;
        int[][]dp = new int[n][n+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        int lengthLongestIS = LongestIncreasingSubSequenceMemo(arr, 0, -1, dp);
        System.out.println(lengthLongestIS);
    }

    public static int LongestIncreasingSubSequenceMemo(int[] arr, int index,
                                                       int previous_index, int[][]dp){

        int n =  arr.length;
//        Base condition
        if(index >= n){
            return 0;
        }

        if(dp[index][previous_index+1] != -1){
            return dp[index][previous_index+1];
        }

        int lengthNotTake;

//        not take

        lengthNotTake = LongestIncreasingSubSequenceMemo(arr, index + 1, previous_index, dp);

//        take
        int lengthTake = 0;
        if(previous_index == -1 || arr[index] > arr[previous_index]){
            lengthTake = 1 + LongestIncreasingSubSequenceMemo(arr, index + 1, index, dp);
        }

        return dp[index][previous_index+1] = Math.max(lengthTake, lengthNotTake);


    }

}
