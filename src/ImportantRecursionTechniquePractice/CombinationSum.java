package ImportantRecursionTechniquePractice;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

        int[] nums = new int[] {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = find(nums, target);
        for(List<Integer> list : result){
            System.out.println(list);
        }
    }

    public static List<List<Integer>> find(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        findCombinationsP(0, result, nums, target, new ArrayList<>());
        return result;
    }

    public static void findCombinationsP(int index,
                                         List<List<Integer>> result, int[] nums, int target, List<Integer> temp) {


        if(target == 0){
            result.add(new ArrayList<>(temp));
            return;
        }

        if(index == nums.length || target < 0)
            return;

        if(nums[index] <= target) {
            temp.add(nums[index]);
            findCombinationsP(index, result, nums, target - nums[index], temp);
            temp.remove(temp.size() - 1);
        }
        findCombinationsP(index + 1, result, nums, target, temp);
    }
}
