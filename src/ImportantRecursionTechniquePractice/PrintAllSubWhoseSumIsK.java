package ImportantRecursionTechniquePractice;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubWhoseSumIsK {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 1};
        int k = 2;

        List<Integer> result = new ArrayList<>();
        printSubWhoseSumIsK(result, arr, k, 0, 0);

        int count = countSubsequencesWhoseSumIsK(arr, 0, k, 0);
        System.out.println("The count value is: " + count);
    }

    public static void  printSubWhoseSumIsK(List<Integer> result, int[] arr, int k, int index, int sum) {

//        base condition

        if(index == arr.length) {
            if(sum == k){
                for(Integer it : result){
                    System.out.print(it + " ");
                }
            }
            System.out.println();
            return;
        }

//        pick condition
        result.add(arr[index]);
        sum += arr[index];
        printSubWhoseSumIsK(result, arr, k, index + 1, sum);

//        not pick condition
        sum -= arr[index];
        result.remove(result.size() - 1);
        printSubWhoseSumIsK(result, arr, k, index + 1, sum);
    }

    public static int countSubsequencesWhoseSumIsK(int[] arr, int sum, int k, int index) {

        if(index == arr.length) {
            if(sum == k){
                return 1;
            }
            return 0;
        }

        sum += arr[index];
        int left = countSubsequencesWhoseSumIsK(arr, sum, k, index + 1);


        sum -= arr[index];
        int right = countSubsequencesWhoseSumIsK(arr, sum, k, index + 1);

        return left + right;
    }
}
