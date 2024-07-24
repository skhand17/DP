package C3AIDPOnStrings;

public class LongestCommonSubstring {

    public static void main(String[] args) {

        String s1 = "abcjklp";
        String s2 = "acjkp";

        int longestCommonSubstring = longestCommonSub(s1, s2);
        System.out.println(longestCommonSubstring);
    }

    private static int longestCommonSub(String s1, String s2) {


        int n =  s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];

//        for(int i=0; i<=n; i++){
//            dp[i][0] = 0;
//        }
//
//
//        for(int j=0; j<=n; j++){
//            dp[0][j] = 0;
//        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        int maxValue = Integer.MIN_VALUE;
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=m; j++) {
                maxValue = Math.max(maxValue, dp[i][j]);
            }
        }
        return maxValue;
    }
}
