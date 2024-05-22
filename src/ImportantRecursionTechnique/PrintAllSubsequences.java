package ImportantRecursionTechnique;

import java.util.ArrayList;
import java.util.List;

/*
* TC : O(2^n)
* SC : O(N)
*
* */
public class PrintAllSubsequences {

    public static void main(String[] args) {
        int [] arr = new int[] {3, 1, 2};
        List<Integer> list = new ArrayList<>();
        printAllSub(0, arr, list, 3);
    }


    public static void printAllSub(int index, int[] arr, List<Integer> list, int n) {
        if(index == n){
            for(Integer i : list){
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        /*
        * Take it
        * */
        list.add(arr[index]);
        printAllSub(index+1, arr, list, n);
        list.remove(list.size() - 1);
        printAllSub(index+1, arr, list, n);
    }
}
