package BackTracking.Practice;

import java.util.ArrayList;
import java.util.List;

/*Time Complexity: O(2^t * k) where t is the target, k is the average length

Reason: Assume if you were not allowed to pick a single element multiple times, every element will have a couple of options: pick or not pick which is 2^n different recursion calls, also assuming that the average length of every combination generated is k. (to put length k data structure into another data structure)

Why not (2^n) but (2^t) (where n is the size of an array)?

Assume that there is 1 and the target you want to reach is 10 so 10 times you can “pick or not pick” an element.

Space Complexity: O(k*x), k is the average length and x is the no. of combinations*/
public class CombSum {

    public static void main(String[] args) {

        int[] arr = new int[] {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> resultant = new ArrayList<>();

        combSum(arr, 0, target, resultant, new ArrayList<>());

        for(List<Integer> innerList : resultant){
            System.out.println(innerList);
        }
    }

    public static void combSum(int[] arr, int index, int target,
                               List<List<Integer>> resultant, List<Integer> list) {


//        base conditions
        if(index == arr.length){
            if(target == 0){
                resultant.add(new ArrayList<>(list));
            }
            return;
        }

        if(arr[index] <= target){
            list.add(arr[index]);
            combSum(arr, index, target - arr[index], resultant, list);
            list.remove(list.size() - 1);
        }

        combSum(arr, index +1 , target, resultant, list);

    }
}
