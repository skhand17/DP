package Knapsack;

import java.util.Arrays;

public class KnapsackZeroOnePracticwe {

    public static void main(String[] args) {

        int[] val = new int[]{80, 110, 60};
        int[] wt = new int[]{3, 2, 4};

        int C = 6;
        int n =4;
        int[][]dp = new int[val.length][C+1];
        for(int[]row : dp){
            Arrays.fill(row, -1);
        }


        int maximumValue = knapsack(wt, val, 0, C, dp);
        System.out.println(maximumValue);
    }

    public static int knapsack(int[] wt, int[]val, int index, int C, int[][]dp){

        if(index == val.length){
            return 0;
        }

        if(dp[index][C] != -1){
            return dp[index][C];
        }


        int notPick = knapsack(wt, val, index + 1, C, dp);
        int pick = 0;

        if(wt[index] <= C){
            pick = val[index] + knapsack(wt, val, index + 1, C - wt[index], dp);
        }

        return dp[index][C] = Math.max(notPick, pick);
    }
}
