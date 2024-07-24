package BackTracking.Practice;

import java.util.ArrayList;
import java.util.List;

public class PallindromePartitioning {

    public static void main(String[] args) {
        String s = "aabb";
        List<List<String>> resultant = generateList(s);
        for(List<String> list : resultant){
            System.out.println(list);
        }
    }

    public static List<List<String>> generateList(String s){
        List<List<String>> resultant = new ArrayList<>();
        partition(s, 0, new ArrayList<>(), resultant);
        return resultant;
    }

    public static void partition(String s, int index, List<String> path, List<List<String>> resultant) {

        if(index == s.length()){
            resultant.add(new ArrayList<>(path));
            return;
        }

        for(int i=index; i<s.length(); i++){
            if(isPallindrome(s, index, i)){
                path.add(s.substring(index, i + 1));
                partition(s, i + 1, path, resultant);
                path.remove(path.size() - 1);
            }
        }
    }
    private static boolean isPallindrome(String s, int start, int end) {

        while (start <= end) {
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
