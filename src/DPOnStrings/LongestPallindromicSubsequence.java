package DPOnStrings;

import java.util.Arrays;

public class LongestPallindromicSubsequence {
    public static void main(String[] args) {

        String text1 = "bbabcbcab";
        String text2 = new StringBuilder(text1).reverse().toString();
        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        int ans = longestPallindromicSubsequence(text1, text2, text1.length() - 1, text2.length() - 1, dp);
        System.out.println(ans);
    }

    public static int longestPallindromicSubsequence(String text1, String text2, int index1, int index2, int[][] dp) {

//        base case

        if (index1 < 0 || index2 < 0)
            return 0;

        if (dp[index1][index2] != -1)
            return dp[index1][index2];

        if (text1.charAt(index1) == text2.charAt(index2))
            return dp[index1][index2] = 1 + longestPallindromicSubsequence(text1, text2, index1 - 1, index2 - 1, dp);
        else
            return dp[index1][index2] = Math.max(longestPallindromicSubsequence(text1, text2, index1 - 1, index2, dp),
                    longestPallindromicSubsequence(text1, text2, index1, index2 - 1, dp));

    }
}
