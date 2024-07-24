package BackTracking.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum2 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 2, 3, 3};
        List<List<Integer>> resultant = generateSubset(arr);
        for(List<Integer> list : resultant){
            System.out.println(list);
        }
    }

    public static List<List<Integer>> generateSubset(int[] arr){
        List<List<Integer>> resultant = new ArrayList<>();
        Arrays.sort(arr);
        subsetSum2(arr, 0, resultant, new ArrayList<>());
        return resultant;
    }

    public static void subsetSum2(int[] arr, int index,
                                  List<List<Integer>> resultant, List<Integer> list) {

        resultant.add(new ArrayList<>(list));
        for(int i=index; i<arr.length; i++){
            if(i!=index && arr[i] == arr[i-1]){
                continue;
            }
            list.add(arr[i]);
            subsetSum2(arr, i+1, resultant, list);
            list.remove(list.size() - 1);
        }
    }
}
