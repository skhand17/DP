package BackTracking;


import java.util.ArrayList;
import java.util.List;

public class PallindromePartitioning {

    public static void main(String[] args) {
        String s = "aabb";
        List<List<String>> res = partition(s);
        for(List<String> li : res){
            System.out.println(li);
        }
    }

    public static List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        partition(s, 0, new ArrayList<>(), result);
        return result;
    }

    public static void partition(String s, int index, List<String> path, List<List<String>> resultant) {

        if(index == s.length()){
            resultant.add(new ArrayList<>(path));
        }

        for(int i=index; i<s.length(); i++){
            if(isPallindrome(s, index, i)){
                path.add(s.substring(index, i+1));
                partition(s, i+1, path, resultant);
                path.remove(path.size() - 1);
            }

        }

    }

    public static boolean isPallindrome(String s, int start, int end) {
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}