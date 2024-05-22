package Two2DConcepts.NinjaTraining;

import java.util.Arrays;

public class MinPathSum {
    public static void main(String[] args) {
        
        int[][]points = new int[][]{

                {10, 8, 2},
                {10, 5, 100},
                {1, 1, 2}
        };

        int row = points.length;
        int col = points[0].length;

        int[][]dp = new int[row][col];

        for(int[] r : dp){
            Arrays.fill(r, -1);
        }

        int minPathSum = minPath(row -1, col - 1, points, dp);
        System.out.println(minPathSum);


        int minPathTab = minPathTab(row, col, points);
        System.out.println(minPathTab);
        

    }

    public static int minPath(int n, int m, int[][] points, int[][] dp){

        if(n == 0 && m == 0)
            return points[n][m];

        if(n < 0 || m < 0)
            return (int) Math.pow(10, 9);

        if(dp[n][m] != -1)
            return dp[n][m];

        int up = points[n][m]  + minPath(n-1, m, points, dp);
        int left = points[n][m] + minPath(n, m-1, points, dp);

        return dp[n][m] = Math.min(up, left);
    }

    /*
    * Tabulation Approach
    *
    * */

    public static int minPathTab(int n, int m, int[][]points) {

        int[][]dp = new int[n][m];
        /*
        *
        * Iterate through the matrix
        *
        * */

        for(int i=0; i<n ;i++){
            for(int j=0; j<m; j++){

                if(i==0 && j==0)
                    dp[i][j] = points[i][j];
                else {
                    int up = points[i][j];
                    if(i > 0)
                        up += dp[i-1][j];
                    else
                        up += (int) Math.pow(10, 9);

                    int left = points[i][j];
                    if(j>0)
                        left += dp[i][j-1];
                    else
                        left += (int)Math.pow(10, 9);



                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        return dp[n-1][m-1];
    }
}
