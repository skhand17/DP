package BackTracking.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombSumIIPractice {

    public static void main(String[] args) {
        int[] nums = new int[]{10,1,2,7,6,1,5};
        int target = 8;

        List<List<Integer>> result = combSum2(nums, target);
        for(List<Integer> list : result){
            System.out.println(list);
        }
    }

    private static List<List<Integer>> combSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        uniqueComb(0, nums, target, result, new ArrayList<>());
        return result;
    }

    private static void uniqueComb(int index, int[] nums,
                                   int target, List<List<Integer>> result,
                                   List<Integer> list) {

        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=index; i<nums.length; i++){
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i] > target)
                break;
            list.add(nums[i]);
            uniqueComb(i+1, nums, target - nums[i], result, list);
            list.remove(list.size() - 1);
        }
    }
}
