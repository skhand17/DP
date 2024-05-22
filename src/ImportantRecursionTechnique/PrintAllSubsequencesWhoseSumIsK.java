package ImportantRecursionTechnique;


import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequencesWhoseSumIsK {


    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 1};
        int k = 2;
        List<Integer> list = new ArrayList<>();

        printAllSubWhoseSumIsK(0, arr, k, 0, arr.length, list);

        boolean ans = printOneSubWhoseSumIsK(0, arr, k, 0, arr.length, list);
        System.out.println(ans);

        int count = countSubWhoseSumIsK(0, arr, k, 0, arr.length);
        System.out.println(count);
    }

    public static void printAllSubWhoseSumIsK(int index, int[] arr, int k, int sum, int n, List<Integer> list) {


        if (index == n) {
            if (sum == k) {
                for (Integer it : list) {
                    System.out.print(it + " ");
                }
                System.out.println();
            }
            return;
        }
//        Take it
        list.add(arr[index]);
        sum += arr[index];
        printAllSubWhoseSumIsK(index + 1, arr, k, sum, n, list);
        list.remove(list.size() - 1);
        sum -= arr[index];

//        Don't take it

        printAllSubWhoseSumIsK(index + 1, arr, k, sum, n, list);
    }

    public static boolean printOneSubWhoseSumIsK(int index, int[] arr, int k, int sum, int n, List<Integer> list) {


        if (index == n) {
            if (sum == k) {
                for (Integer it : list) {
                    System.out.print(it + " ");
                }
                System.out.println();
                return true;
            }
            /*Condition not satisfied*/
            return false;
        }
//        Take it
        list.add(arr[index]);
        sum += arr[index];
        if(printOneSubWhoseSumIsK(index + 1, arr, k, sum, n, list)){
            return true;
        }
        list.remove(list.size() - 1);
        sum -= arr[index];

//        Don't take it

        if(printOneSubWhoseSumIsK(index + 1, arr, k, sum, n, list)){
            return true;
        }
        return false;
    }

    public static int countSubWhoseSumIsK(int index, int[] arr, int k, int sum, int n) {


        if (index == n) {
            if (sum == k) {
//                for (Integer it : list) {
//                    System.out.print(it + " ");
//                }
//                System.out.println();
                return 1;
            }
            return 0;
        }
//        Take it
//        list.add(arr[index]);
        sum += arr[index];
        int left = countSubWhoseSumIsK(index + 1, arr, k, sum, n);
//        list.remove(list.size() - 1);
        sum -= arr[index];

//        Don't take it

        int right = countSubWhoseSumIsK(index + 1, arr, k, sum, n);

        return left + right;
    }
}
