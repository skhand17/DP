package BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSumI {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2};
        List<Integer> result = subsetSum(arr);
        for(int i: result){
            System.out.print(i + " ");
        }
    }

    public static List<Integer> subsetSum(int[] arr) {
        List<Integer> list = new ArrayList<>();
        subsetSumHelper(arr, 0, list, 0);
        Collections.sort(list);
        return list;
    }

    public static void subsetSumHelper(int[] arr, int index, List<Integer> list, int sum) {
        if(index == arr.length) {
            list.add(sum);
            return;
        }

        /*Picking up the element*/
        subsetSumHelper(arr, index + 1,list,sum + arr[index]);

        /*Not picking up the element*/
        subsetSumHelper(arr, index + 1, list, sum);

    }
}
