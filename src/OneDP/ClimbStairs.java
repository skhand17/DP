package OneDP;

import java.util.Arrays;

class ClimbStairs {
    public int climbStairs(int n) {

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        int sol = countWays(n, dp);
        return sol;
    }

    public static int countWays(int index, int[] dp) {

        if(index == 0) {
            return 1;
        }

        if(index == 1) {
            return 1;
        }

        if(dp[index] != -1){
            return dp[index];
        }

        int left = countWays(index - 1, dp);
        int right = countWays(index - 2, dp);

        return dp[index] = left + right;
    }
}
