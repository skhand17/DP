package ImportantRecursionTechniquePractice;

import java.util.ArrayList;
import java.util.List;

public class PallindromePartioning {

    public static void main(String[] args) {
        String s = "aabb";
        List<List<String>> result = pallindromePart(s);
        for(List<String> list : result) {
            System.out.println(list);
        }
    }

    public static List<List<String>> pallindromePart(String s) {

        List<List<String>> result = new ArrayList<>();

        computePallindromePart(0,  s, result, new ArrayList<>());
        return result;
    }

    private static void computePallindromePart(int index, String s,
                                               List<List<String>> result,
                                               ArrayList<String> temp) {


//        base condition
        if(index == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index; i<s.length(); i++) {
            if(isPallindrome(s, index, i)) {
                temp.add(s.substring(index, i + 1));
                computePallindromePart(i + 1, s, result, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
    private static boolean isPallindrome(String s, int start, int end) {
        while(start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

}
