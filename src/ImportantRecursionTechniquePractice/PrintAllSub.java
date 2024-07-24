package ImportantRecursionTechniquePractice;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSub {

    public static void main(String[] args) {

        int[] nums = new int[] {1, 2, 3};
        List<Integer> result = new ArrayList<>();
        printSubsequences(nums, result, 0);
    }

    public static void printSubsequences(int[] nums, List<Integer> result, int index) {

        if(index == nums.length) {
//            base condition
            for(Integer items : result){
                System.out.print(items + " ");
            }
            System.out.println();
            return;
        }


//        pick condition
        result.add(nums[index]);
        printSubsequences(nums, result, index + 1);

//        not pick condition
        result.remove(result.size() - 1);
        printSubsequences(nums, result, index + 1);


    }
}
