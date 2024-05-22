package DPOnStrings;

import java.util.Collections;

public class PrintLCS {
    public static void main(String[] args) {

        String text1 = "abcde";
        String text2 = "bdgek";

         String ans = LCSTab(text1,text2);
        System.out.println(ans);
    }

    public static String LCSTab(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int[][]dp = new int[n+1][m+1];

        for(int j=0; j<=m; j++){
            dp[0][j] = 0;
        }

        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){

                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
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
        StringBuilder stringBuilder = new StringBuilder();
        while(index1 > 0 && index2 > 0){

            if(text1.charAt(index1-1) == text2.charAt(index2-1)){
                stringBuilder.append(text1.charAt(index1-1));
                index1 = index1 - 1;
                index2 = index2 - 1;
            }
            else if(dp[index1-1][index2] > dp[index1][index2 - 1]) {
                index1 = index1 - 1;
            } else {
                index2 = index2 - 1;
            }
        }

        return stringBuilder.reverse().toString();
    }
}
