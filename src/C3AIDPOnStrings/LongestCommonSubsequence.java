package C3AIDPOnStrings;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {

        String s1 = "acd";
        String s2 = "ced";

        int lenS1 = s1.length();
        int lenS2 = s2.length();

        int[][] dp = new int[lenS1][lenS2];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        int longestCommon = lcs(s1, s2, lenS1 - 1, lenS2 - 1, dp);
        System.out.println(longestCommon);
    }

    public static int lcs(String s1, String s2, int index1, int index2, int[][] dp) {

//        base condition
        if(index1 < 0 || index2 < 0)
            return 0;

        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }

        if(s1.charAt(index1) == s2.charAt(index2)){
            return dp[index1][index2] =  1 + lcs(s1, s2, index1 - 1, index2 - 1, dp);
        } else {
            return dp[index1][index2] =  Math.max(lcs(s1, s2, index1 - 1, index2, dp) , lcs(s1, s2, index1, index2 - 1, dp));
        }

    }
}
