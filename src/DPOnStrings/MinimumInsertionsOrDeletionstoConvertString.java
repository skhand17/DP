package DPOnStrings;

import java.util.Arrays;

public class MinimumInsertionsOrDeletionstoConvertString {
    public static void main(String[] args) {
        String word1 = "abcd";
        String word2 = "anc";
        int[][] dp = new int[word1.length()][word2.length()];
        for (int[] rows : dp)
            Arrays.fill(rows, -1);

        int length = longestCommonSubsequence(word1, word2, word1.length() - 1, word2.length() - 1, dp);

        System.out.println(((word1.length() - length) + (word2.length() - length)));
    }

    private static int longestCommonSubsequence(String word1, String word2, int index1, int index2, int[][] dp) {
        if (index1 < 0 || index2 < 0)
            return 0;

        if (dp[index1][index2] != -1)
            return dp[index1][index2];

        if (word1.charAt(index1) == word2.charAt(index2)) {
            return dp[index1][index2] = 1 + longestCommonSubsequence(word1, word2, index1 - 1, index2 - 1, dp);

        } else {
            return dp[index1][index2] = Math.max(longestCommonSubsequence(word1, word2, index1 - 1, index2, dp), longestCommonSubsequence(word1, word2, index1, index2 - 1, dp));
        }
    }
}
