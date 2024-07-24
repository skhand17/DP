package DPOnStrings.Practice;

public class LongestCommonSubstring {

    public static void main(String[] args) {

        String S1 = "abcjklp";
        String S2 = "acjkp";

        int ans = longestCommonSubstr(S1, S2, S1.length(), S2.length());
        System.out.println(ans);

    }
       public static int longestCommonSubstr(String S1, String S2, int n, int m){

            // code here

            int[][]dp = new int[n+1][m+1];

            for(int i=0; i<=n; i++){
                dp[i][0] = 0;
            }

            for(int j=0; j<=m; j++){
                dp[0][j] = 0;
            }

            for(int i=1; i<=n; i++) {
                for(int j=1; j<=m; j++){

                    if(S1.charAt(i-1) == S2.charAt(j-1)) {
                        // match
                        dp[i][j] = 1 + dp[i-1][j-1];
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }

            int maxValue = Integer.MIN_VALUE;

            for(int i=0; i<=n; i++){
                for(int j=0; j<=m; j++){
                    maxValue = Math.max(maxValue, dp[i][j]);
                }
            }

            return maxValue;

        }
    }
