package DPOnStrings;

public class LongestCommonSubStringPractice {

    public static void main(String[] args) {

        String s = "abcjklp";
        String t = "acjkp";
        int index1 = s.length() - 1;
        int index2 = t.length() - 1;

        int ans = lengthSubstring(s, t, index1, index2);
        System.out.println(ans);
    }

    public static int lengthSubstring(String s, String t, int index1, int index2) {

        if(index1 < 0 || index2 < 0)
            return 0;

//        matching condition
        if(s.charAt(index1) == t.charAt(index2)){
            return 1 + lengthSubstring(s, t, index1 - 1, index2 - 1);
        }else
            return 0;
    }
}
