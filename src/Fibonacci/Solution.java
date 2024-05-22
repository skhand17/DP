package Fibonacci;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int n = 10;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        System.out.println(fibo(n, dp));
        fiboUsingTab(n);
        fiboSpaceOpti(n);


    }


    /*
    * Memoization and Recursive technique
    *
    * */
    private static int fibo(int n, int[] dp) {

        if(n <= 1)
            return n;

        if(dp[n] != -1)
            return dp[n];

        return dp[n] = fibo(n-1, dp) + fibo(n-2, dp);
    }

    private static void fiboUsingTab(int n){

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[n]);
    }

    /*
    * Space Optimization Solution
    * TC : O(N)
    * SC : O(1)
    * */
    private static void fiboSpaceOpti(int n){

//        int[] dp = new int[n+1];
//        Arrays.fill(dp, -1);

        int prev2 = 0;
        int prev = 1;

        for(int i=2; i<=n; i++){
            int current = prev + prev2;
            prev2 = prev;
            prev = current;
        }

        System.out.println(prev);
    }
}
