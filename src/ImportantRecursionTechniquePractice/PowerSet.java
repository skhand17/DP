package ImportantRecursionTechniquePractice;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static void main(String[] args) {

        int[] nums = new int[] {100, 101, 102};

        int totalNumberOfSubsets = 1 << nums.length;

        List<List<Integer>> result = powersets(nums, totalNumberOfSubsets);

        for(List<Integer> list :  result) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> powersets(int[] nums, int totalNoSubsets) {

        List<List<Integer>> resultant = new ArrayList<>();

        for(int num = 0; num < totalNoSubsets; num++) {

            List<Integer> temp = new ArrayList<>();

            for(int j=0; j<nums.length; j++) {
                if((num & (1 << j)) != 0){
                    temp.add(nums[j]);
                }
            }
            resultant.add(temp);
        }
    return resultant;
    }
}
