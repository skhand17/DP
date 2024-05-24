package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> resultant = combinationSum2(candidates, target);
        for(List<Integer> inner: resultant){
            System.out.println(inner);
        }

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> resultant = new ArrayList<>();
        uniqueCombinations2(candidates, target, 0, resultant, new ArrayList<>());
        return resultant;

    }

    public static void uniqueCombinations2(int[] arr, int target, int index,
                                           List<List<Integer>> resultant, List<Integer> list) {


        if(target == 0){
            resultant.add(new ArrayList<>(list));
            return;
        }

        for(int i=index; i< arr.length; i++){
            if(i > index && arr[i] == arr[i-1])
                continue;

            if(arr[index] > target)
                break;

            list.add(arr[i]);
            uniqueCombinations2(arr, target - arr[i], i + 1, resultant, list);
            list.remove(list.size() - 1);
        }
    }
}
