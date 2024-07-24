package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombSumPractice {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> resultant = comb(nums, target);
        for(List<Integer> list : resultant){
            System.out.println(list);
        }
    }

    public static List<List<Integer>> comb(int[] nums, int target) {
        List<List<Integer>> resultant = new ArrayList<>();

        f(0, nums, target, resultant, new ArrayList<>());

        return resultant;
    }
    public static void f(int index, int[] nums , int target,
                         List<List<Integer>> resultant, List<Integer> temp) {

        if(target == 0){
            resultant.add(new ArrayList<>(temp));
            return;
        }
        if(index == nums.length || target < 0)
            return;

        if(nums[index] <= target){
            temp.add(nums[index]);
            f(index, nums, target - nums[index], resultant, temp);
            temp.remove(temp.size() - 1);
        }
        f(index+1, nums, target, resultant,temp);
    }
}
