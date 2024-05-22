package DPOnStrings;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {

        String s1 = "bbbab";
        String s2 = "babbb";


        int[][] dp = new int[s1.length()][s2.length()];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        int lcs = LCS(s1, s2, s1.length() - 1, s2.length() - 1, dp);
        System.out.println(lcs);

        int lcsTab = LCSTab(s1, s2);
        System.out.println(lcsTab);
    }

    public static int LCS(String s1, String s2, int index1, int index2, int[][] dp) {

//        Base condition we will write later on

        if (index1 < 0 || index2 < 0)
            return 0;
        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

//        Match
        if (s1.charAt(index1) == s2.charAt(index2)) {
            return dp[index1][index2] = 1 + LCS(s1, s2, index1 - 1, index2 - 1, dp);
            /*
             * Not Match condition*/
        } else {
            return dp[index1][index2] = Math.max(LCS(s1, s2, index1 - 1, index2, dp),
                                                LCS(s1, s2, index1, index2 - 1, dp));
        }

    }

    public static int LCSTab(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[][]dp = new int[n+1][m+1];
        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }
//        Base condition we will write later on

        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }

        for(int j=0; j<=m; j++){
            dp[0][j] = 0;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){

                if(s1.charAt(i -1) == s2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
