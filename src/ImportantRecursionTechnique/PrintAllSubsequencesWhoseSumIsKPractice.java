package ImportantRecursionTechnique;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequencesWhoseSumIsKPractice {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 1};
        int k = 2;
        List<Integer> list = new ArrayList<>();
        f(arr, 0, 0, k, list);
    }

    public static void f(int[] arr, int index, int sum, int target, List<Integer> list) {

//        base condition

        if(index ==  arr.length){

            if(sum == target) {
                for(Integer it : list){
                    System.out.print(it + " ");
                }
                System.out.println();
            }
            return;
        }

//        picking an element
        list.add(arr[index]);
        sum += arr[index];
        f(arr, index + 1, sum, target, list);
        list.remove(list.size() - 1);
        sum -= arr[index];

//        Not picking an element
        f(arr, index + 1, sum, target, list);



    }
}
