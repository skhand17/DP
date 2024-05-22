package DPOnStrings;

import java.util.Arrays;

public class MinInsertionsToMakeStringPallindrome {

    public static void main(String[] args) {


        String s = "codingninjas";
        String t = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[s.length()][s.length()];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        int longestPSubse = longestPallindromeSub(s, t, s.length() - 1, t.length() - 1, dp);
        System.out.println(s.length() - longestPSubse);
    }

    private static int longestPallindromeSub(String s, String t, int i1, int i2, int[][] dp) {

        if(i1 < 0 || i2 < 0)
            return 0;

        if(dp[i1][i2] != -1)
            return dp[i1][i2];

        if(s.charAt(i1) == t.charAt(i2))
            return dp[i1][i2] = 1 + longestPallindromeSub(s, t, i1-1, i2-1, dp);
        else
            return dp[i1][i2] = Math.max(longestPallindromeSub(s, t, i1-1, i2, dp),
                    longestPallindromeSub(s, t, i1, i2-1, dp));
    }
}
