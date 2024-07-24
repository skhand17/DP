package OneDP;

import java.util.Arrays;

class FrogJumpI{
    public int minimumEnergy(int arr[],int N){
        //code here

        int[] dp = new int[N+1];
        Arrays.fill(dp, -1);
        int ans = minimum(arr, N-1, dp);
        return ans;
    }

    public int minimum(int[] arr, int index, int[] dp) {

        if(index == 0){
            return 0;
        }

        if(dp[index] != -1) {
            return dp[index];
        }

        int left = minimum(arr, index - 1, dp) + Math.abs(arr[index] - arr[index - 1]);
        int right = Integer.MAX_VALUE;
        if(index > 1) {
            right = minimum(arr, index - 2, dp) + Math.abs(arr[index] - arr[index - 2]);
        }
        return dp[index] = Math.min(left, right);
    }
}
