package ImportantRecursionTechniquePractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetI {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2};

        List<Integer> result = subsetSumI(arr);
        System.out.println(result);
    }

    public static List<Integer> subsetSumI(int[] arr) {
        List<Integer> result = new ArrayList<>();

        computeSubsetSumI(0, arr, result, 0);
        Collections.sort(result);
        return result;
    }

    private static void computeSubsetSumI(int index, int[] arr,
                                          List<Integer> result, int sum) {

        if(index == arr.length) {
            result.add(sum);
            return;
        }

//        if I am picking it
        computeSubsetSumI(index + 1, arr, result, sum + arr[index]);

//        if I am not picking it
        computeSubsetSumI(index + 1, arr, result, sum);

    }
}
