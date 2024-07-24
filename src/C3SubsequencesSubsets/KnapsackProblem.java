package C3SubsequencesSubsets;

import java.util.Arrays;

public class KnapsackProblem {

    public static void main(String[] args) {
        int[] val = new int[]{80, 110, 60};
        int[] wt = new int[]{3, 2, 4};

        int Capacity = 6;

        int[][] dp = new int[wt.length][Capacity + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int valueMaximum = maximumValue(0, Capacity, wt, val, dp);
        System.out.println(valueMaximum);

    }

    public static int maximumValue(int index, int Capacity, int[] wt, int[] val, int[][] dp) {

//        base condition
        if(index == wt.length)
            return 0;

        int notPick = maximumValue(index + 1, Capacity, wt, val, dp);
        int pick = 0;

        if(Capacity >= wt[index]) {
            pick = val[index] + maximumValue(index + 1, Capacity - wt[index], wt, val, dp);
        }

        return dp[index][Capacity] = Math.max(notPick, pick);
    }
}
