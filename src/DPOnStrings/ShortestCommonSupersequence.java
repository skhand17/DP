package DPOnStrings;

public class ShortestCommonSupersequence {

    public static void main(String[] args) {

        String text1 = "brute";
        String text2 = "groot";

        String scs = lcs(text1, text2);
        System.out.println(scs);

    }

    public static String lcs(String tex1, String text2) {

        int n = tex1.length();
        int m = text2.length();

        int[][]dp = new int[n+1][m+1];

        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }

        for(int j=0; j<=m; j++){
            dp[0][j] = 0;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){

                if(tex1.charAt(i-1) == text2.charAt(j-1)){
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


        StringBuilder stringBuilder = new StringBuilder();
        int index1 = n;
        int index2 = m;

        while (index1 > 0 && index2 > 0) {

            if(tex1.charAt(index1-1) == text2.charAt(index2-1)){
                stringBuilder.append(tex1.charAt(index1-1));
                index1 = index1 - 1;
                index2 = index2 - 1;
            } else if (dp[index1-1][index2] > dp[index1][index2-1]){
                stringBuilder.append(tex1.charAt(index1-1));
                index1 = index1 - 1;
            } else {
                stringBuilder.append(text2.charAt(index2-1));
                index2 = index2 - 1;
            }
        }

        while (index1 > 0){
            stringBuilder.append(tex1.charAt(index1-1));
            index1--;
        }
        while (index2 > 0){
            stringBuilder.append(text2.charAt(index2-1));
            index2--;
        }

        return stringBuilder.reverse().toString();
    }
}
