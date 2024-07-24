package DPOnStrings.Practice;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {

        String s1 = "adebc";
        String s2 = "dcadb";

        int i1 = s1.length() - 1;
        int i2 = s2.length() - 1;

        int[][]dp = new int[s1.length()][s2.length()];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }


        int lengthOfLCS = lcs(s1, s2, i1, i2, dp);
        System.out.println(lengthOfLCS);

        int lengthOfLCSTab = lcsTabulation(s1, s2);
        System.out.println(lengthOfLCSTab);
    }

    public static int lcs(String s1, String s2, int i1, int i2, int[][]dp){

//        base condition
        if(i1 < 0 || i2 < 0)
            return 0;

        if(dp[i1][i2] != -1){
            return dp[i1][i2];
        }
//        Match Condition

        if(s1.charAt(i1) == s2.charAt(i2)){
            return dp[i1][i2] =  1 + lcs(s1, s2, i1 - 1, i2 - 1, dp);
        } else {

//            Not match condition
            return dp[i1][i2] = Math.max(lcs(s1, s2, i1, i2-1, dp), lcs(s1, s2, i1-1, i2, dp));
        }
    }

    public static int lcsTabulation(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();
//        Initialize a DP array by shifting indexes
        int[][]dp = new int[n+1][m+1];


//        base condition

        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }

        for(int j=0; j<=m; j++){
            dp[0][j] = 0;
        }

//        Recursive solution

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }

        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }


        int index1 = n;
        int index2 = m;

        StringBuilder sb = new StringBuilder();

        while (index1 > 0 && index2 > 0) {

            if(s1.charAt(index1 - 1) == s2.charAt(index2 - 1)){
                sb.append(s1.charAt(index1 - 1));
                index1--;
                index2--;
            } else {
                if(dp[index1-1][index2] > dp[index1][index2-1]){
                    index1 --;
                } else {
                    index2--;
                }
            }
        }
        System.out.println(sb.reverse().toString());

        return dp[n][m];
    }
}
