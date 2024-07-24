package DPOnStrings;

import java.util.Arrays;

public class LongestCommonSubstring {

    public static void main(String[] args) {

        String text1 = "abcjklp";
        String text2 = "acjkp";


        int length = longestCommonSubstring(text1, text2);
        System.out.println(length);

    }

    public static int longestCommonSubstring(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

//        Base condition
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (text1.charAt(i - 1) == text2.charAt(i - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

}
