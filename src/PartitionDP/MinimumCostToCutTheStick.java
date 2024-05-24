package PartitionDP;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.*;

public class MinimumCostToCutTheStick {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 5};
        int n = 7;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i: arr)
            list.add(i);
        list.add(0);
        list.add(n);
        int[][]dp = new int[arr.length+1][arr.length+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        Collections.sort(list);

        System.out.println(minCostToCut(list, 1, arr.length, dp));
    }

    public static int minCostToCut(ArrayList<Integer> list, int i, int j, int[][]dp) {

        if(i>j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int minCost = (int)Math.pow(10, 9);

        for(int k=i; k<=j; k++){

            int cost = list.get(j+1) - list.get(i-1) + minCostToCut(list, i, k-1, dp)
                    + minCostToCut(list, k+1, j, dp);

            minCost = Math.min(minCost, cost);
        }
        return dp[i][j] = minCost;
    }
}
