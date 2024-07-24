package BackTracking.Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSum {

    public static void main(String[] args) {

        int[] arr = new int[] {3, 1, 2};
        List<Integer> list = generateSubsets(arr);

        for(Integer it: list){
            System.out.print(it + " ");
        }
    }

    public static List<Integer> generateSubsets(int[] arr){
        List<Integer> list = new ArrayList<>();
        subsetSum(arr, 0, 0, list);
        Collections.sort(list);
        return list;
    }

    public static void subsetSum(int[] arr, int index, int sum, List<Integer> list) {

        if(index == arr.length){
            list.add(sum);
            return;
        }

        sum += arr[index];
        subsetSum(arr, index + 1, sum, list);
        sum -= arr[index];
        subsetSum(arr, index + 1, sum, list);
    }
}
