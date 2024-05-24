package PartitionDP;

import java.util.ArrayList;
import java.util.Arrays;

public class BurstsBalloons {

    public static void main(String[] args) {
        int[] ballons = new int[]{3, 1, 5, 8};

        ArrayList<Integer> ballonList = new ArrayList<>();
        for(int i: ballons){
            ballonList.add(i);
        }

        ballonList.add(1);
        ballonList.add(0,1);

        int[][]dp = new int[ballons.length + 2][ballons.length + 2];
        for(int[]row : dp){
            Arrays.fill(row, -1);
        }

        System.out.println(maximize(ballonList, 1, ballons.length, dp));

    }

    public static int maximize(ArrayList<Integer> ballons, int i, int j, int[][]dp) {

        if(i > j)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int maxi = Integer.MIN_VALUE;
        for(int index=i; index<=j; index++){
            int cost = ballons.get(i-1) * ballons.get(index) * ballons.get(j+1) +
                    maximize(ballons, i, index-1, dp) + maximize(ballons, index + 1, j, dp);

            maxi = Math.max(maxi, cost);
        }
        return dp[i][j] = maxi;
    }
}
