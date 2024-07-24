package ImportantRecursionTechnique;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequencesPractice {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3};
        List<Integer> list = new ArrayList<>();
        printAllSubsequences(list, arr, 0);
    }

    public static void printAllSubsequences(List<Integer> list, int[] arr, int index) {

//        base condition

        if(index == arr.length){
            for(Integer it: list){
                System.out.print(it + " ");
            }
            System.out.println();
            return;
        }

        list.add(arr[index]);
//        Picking an element
        printAllSubsequences(list, arr, index + 1);
        list.remove(list.size() - 1);
//        Not picking an element
        printAllSubsequences(list, arr, index + 1);
    }
}
