package ImportantRecursionTechniquePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombSumII {

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> result = combII(candidates, target);
        for(List<Integer> list : result){
            System.out.println(list);
        }
    }

    public static List<List<Integer>> combII(int[] candidate, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidate);
        findCombII(candidate, target, 0, result, new ArrayList<>());
        return result;
    }

    private static void findCombII(int[] candidate, int target, int index,
                                   List<List<Integer>> result, List<Integer> temp) {


        if(target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index; i<candidate.length; i++) {
            if(i > index && candidate[i] == candidate[i-1]) {
                continue;
            }
            if(candidate[i] > target)
                break;

            temp.add(candidate[i]);
            findCombII(candidate, target - candidate[i], i+1, result, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
