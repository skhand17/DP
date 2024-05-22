package FrogJump;


/*
*
* f(index) {
*
* if(index == 0) return 0;
*
* int left = f(index - 1) + Math.abs(a[index] - a[index-1]);
* int right = f(index - 2) + Math.abs(a[index] - a[index - 2]);
*
* return Math.min(left, right);
*
* */

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] arr = new int[] {30, 10, 60, 10, 60, 50};
        int n = 6;

        int minimumWay = frogJumpRecursion(n-1, arr);
        System.out.println(minimumWay);

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        int minWay = frogJumpMemoization(n-1, arr, dp);
        System.out.println(minWay);

        int minWay2 = frogJumpTabulation(n-1, arr, dp);
        System.out.println(minWay2);

        int minWay3 = frogJumpTabulationSpaceOtimized(n-1, arr);
        System.out.println(minWay3);
    }

    public static int frogJumpRecursion(int index, int[] arr) {
        if(index == 0)
            return 0;

        int left = frogJumpRecursion(index - 1, arr) + Math.abs(arr[index] - arr[index -1]);
        int right = Integer.MAX_VALUE;
        if(index > 1) {
            right = frogJumpRecursion(index - 2, arr) + Math.abs(arr[index] - arr[index - 2]);
        }
        return Math.min(left, right);
    }

    /*
    * Converting a Recursion into a frog jump Memoization
    *
    * */

    public static int frogJumpMemoization(int index, int[] arr, int[] dp) {

        if(index == 0)
            return 0;

        if(dp[index] != -1){
            return dp[index];
        }

        int left = frogJumpMemoization(index - 1, arr, dp) + Math.abs(arr[index] - arr[index-1]);
        int right = Integer.MAX_VALUE;

        if(index > 1){
            right = frogJumpMemoization(index -2, arr, dp) + Math.abs(arr[index] - arr[index - 2]);
        }

        return dp[index] = Math.min(left, right);

    }

    public static int frogJumpTabulation(int index, int[]arr, int[] dp) {

        dp[0] = 0;

        for(int i=1; i<index; i++) {

            int firstStep = dp[index - 1] + Math.abs(arr[index] - arr[index - 1]);
            int secondStep = Integer.MAX_VALUE;

            if (index > 1) {
                secondStep = dp[index - 2] + Math.abs(arr[index] - arr[index - 2]);
            }


            dp[index] = Math.min(firstStep, secondStep);
        }

        return dp[index];

    }

    public static int frogJumpTabulationSpaceOtimized(int index, int[]arr) {

        int prev = 0;
        int prev2 = 0;

        for(int i=1; i<index; i++) {

            int firstStep = prev + Math.abs(arr[index] - arr[index - 1]);
            int secondStep = Integer.MAX_VALUE;

            if (index > 1) {
                secondStep = prev2 + Math.abs(arr[index] - arr[index - 2]);
            }

            int curri = Math.min(firstStep, secondStep);
            prev2 = prev;
            prev = curri;
        }

        return prev;

    }




}
