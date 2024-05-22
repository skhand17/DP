package Two2DConcepts.NinjaTraining;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[][]points = new int[][]{

                {2, 1, 3},
                {3, 4, 6},
                {10, 1, 6},
                {8, 3, 7}
        };

        int[][]dp = new int[points.length][4];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        int ans = f(points.length - 1, 3, dp, points);
        System.out.println(ans);

    }

    public static int f(int day, int lastTask, int[][]dp, int[][]points) {

        if(dp[day][lastTask] != -1)
            return dp[day][lastTask];

        if(day == 0){
            int maxi =0;

            for(int task =0; task < 3; task ++){
                if(task != lastTask){
                    maxi = Math.max(maxi, points[0][task]);
                }
            }
            return dp[day][lastTask];
        }

        int maxi = 0;

        for(int task = 0; task<3; task ++){

            if(task != lastTask){
                int p = points[day][task] + f(day - 1, task, dp, points);
                maxi = Math.max(maxi, p);
            }
        }
        return dp[day][lastTask] = maxi;
    }
}
