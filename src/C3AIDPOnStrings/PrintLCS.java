package C3AIDPOnStrings;

public class PrintLCS {
    public static void main(String[] args) {
        String s1 = "acd";
        String s2 = "ced";

        String lcs = lcsTab(s1, s2);
        System.out.println(lcs);
    }

    private static String lcsTab(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }

        for(int j=0; j<=m; j++){
            dp[0][j] = 0;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
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
            } else if (dp[index1 - 1][index2] > dp[index1][index2 - 1]){
                index1--;
            } else {
                index2--;
            }
        }
        return sb.reverse().toString();
    }
}
