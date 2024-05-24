package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSumII {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 2};
        List<List<Integer>> result = subsetSum2(arr);
        for(List<Integer> list : result){
            System.out.println(list);
        }
    }

    public static List<List<Integer>> subsetSum2(int[] arr) {
        List<List<Integer>> resultant = new ArrayList<>();
        Arrays.sort(arr);

        subsetSum2Unique(arr, 0, resultant, new ArrayList<>());

        return resultant;
    }

    public static void subsetSum2Unique(int[] arr, int index, List<List<Integer>> resultant, List<Integer>list) {
        resultant.add(new ArrayList<>(list));
        for(int i=index; i<arr.length; i++){
            if(i!=index && arr[i] == arr[i-1])
                continue;
            list.add(arr[i]);
            subsetSum2Unique(arr, i +1, resultant, list);
            list.remove(list.size() - 1);
        }
    }
}
