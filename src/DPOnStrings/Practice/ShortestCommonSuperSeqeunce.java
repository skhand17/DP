package DPOnStrings.Practice;

public class ShortestCommonSuperSeqeunce {

    public static void main(String[] args) {
        String s = "abac";
        String t = "cab";

        int n = s.length();
        int m = t.length();

        String result = shortestCommonSupersequence(s, t, n , m);
        System.out.println(result);
    }

    public static String shortestCommonSupersequence(String s, String t, int n, int m) {

        int[][]dp = new int[n+1][m+1];

        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<=m; j++){
            dp[0][j] = 0;
        }

        for(int index1=1; index1 <= n; index1++) {
            for(int index2=1; index2 <=m; index2++) {

//                matching condition

                if(s.charAt(index1-1) == t.charAt(index2-1)){
                    dp[index1][index2] = 1 + dp[index1-1][index2-1];
                } else {
                    dp[index1][index2] = Math.max(dp[index1-1][index2], dp[index1][index2-1]);
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

            if(s.charAt(index1 - 1) == t.charAt(index2 - 1)){
                stringBuilder.append(s.charAt(index1 - 1));
                index1--;
                index2--;
            } else if(dp[index1-1][index2] > dp[index1][index2-1]){
                stringBuilder.append(s.charAt(index1-1));
                index1--;
            } else {
                stringBuilder.append(t.charAt(index2-1));
                index2--;
            }
        }

        while (index1 > 0){
            stringBuilder.append(s.charAt(index1-1));
            index1--;
        }
        while (index2 > 0){
            stringBuilder.append(t.charAt(index2-1));
            index2--;
        }

        return stringBuilder.toString();
    }


}
