package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPermuationsOfAStringArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        List<List<Integer>> resultant = permute(arr);
        for(List<Integer> list : resultant){
            System.out.println(list);
        }
    }

    public static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> resultant = new ArrayList<>();
        permuteRecur(arr, 0, resultant);
        return resultant;
    }

    public static void permuteRecur(int[] arr, int index, List<List<Integer>> resultant) {
        if(index == arr.length){
            List<Integer> list = new ArrayList<>();
            for(int i: arr){
                list.add(i);
            }
            resultant.add(new ArrayList<>(list));
            return;
        }
        for(int i=index; i<arr.length; i++){
            swap(i, index, arr);
            permuteRecur(arr, index+1, resultant);
            swap(i, index, arr);
        }

    }

    public static void swap(int i, int j, int[]arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]  = temp;
    }
}
