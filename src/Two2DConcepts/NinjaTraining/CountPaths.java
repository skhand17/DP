
package Two2DConcepts.NinjaTraining;

import java.util.Arrays;

public class CountPaths {

    public static void main(String[] args) {

        int[][] points = new int[][]{
                {1, 2},
                {3, 4},
                {5, 6}
        };

        int n = points.length;
        int m = points[0].length;

        int[][] dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int count = countPath(n - 1, m - 1, dp);
        System.out.println(count);
    }

    public static int countPath(int n, int m, int[][] dp) {

        if (n == 0 && m == 0)
            return 1;

        if (n < 0 || m < 0)
            return 0;

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        int up = countPath(n - 1, m, dp);
        int left = countPath(n, m - 1, dp);

        return dp[n][m] = up + left;
    }
}

