package BackTracking.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombSumII {

    public static void main(String[] args) {

        int[] arr = new int[] {2, 1, 2, 1, 1};
        int target = 4;
        List<List<Integer>> resultant = generateCombinations(arr, target);
        for(List<Integer> list : resultant){
            System.out.println(list);
        }

    }

    public static List<List<Integer>> generateCombinations(int[] arr, int target) {
        List<List<Integer>> resultant = new ArrayList<>();
        Arrays.sort(arr);
        combSum2(arr, 0, target, resultant, new ArrayList<>());
        return resultant;
    }


    public static void combSum2(int[] arr, int index, int target,
                                List<List<Integer>> resultant, List<Integer> list) {

        if(target == 0){
            resultant.add(new ArrayList<>(list));
            return;
        }

        for(int i=index; i<arr.length; i++){
            if( i > index && arr[i] == arr[i-1]){
                continue;
            }
            if(arr[i] > target){
                break;
            }
            list.add(arr[i]);
            combSum2(arr, i + 1, target - arr[i], resultant, list);
            list.remove(list.size() - 1);
        }






    }

}
