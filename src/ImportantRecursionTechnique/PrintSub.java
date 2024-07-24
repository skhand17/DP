package ImportantRecursionTechnique;

import java.util.ArrayList;
import java.util.List;

public class PrintSub {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<Integer> result = new ArrayList<>();
        List<Integer> result1 = new ArrayList<>();
        int k = 3;
        subsequences(0, nums, result);
        subsequencesCountK(0, nums, 0, k, result1);

        int count = countSubK(0, nums, 0, k);
        System.out.println("The count of subsequences whose sum is k " +count);

    }

    private static int countSubK(int index, int[] nums, int sum, int k) {

        if (index == nums.length) {
            if (sum == k) {
                return 1;
            } else
                return 0;
        }

        sum += nums[index];
        int left = countSubK(index + 1, nums, sum, k);
        sum -= nums[index];
        int right = countSubK(index + 1, nums, sum, k);
        return left + right;
    }

    public static void subsequences(int index, int[] nums, List<Integer> result) {

        if (index == nums.length) {
            for (Integer i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        result.add(nums[index]);
        subsequences(index + 1, nums, result);
        result.remove(result.size() - 1);
        subsequences(index + 1, nums, result);
    }

    public static void subsequencesCountK(int index, int[] nums, int sum, int target, List<Integer> result) {
        if (index == nums.length) {
            if (sum == target) {
                for (Integer i : result) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            return;
        }
        sum += nums[index];
        result.add(nums[index]);
        subsequencesCountK(index + 1, nums, sum, target, result);
        sum -= nums[index];
        result.remove(result.size() - 1);
        subsequencesCountK(index + 1, nums, sum, target, result);
    }
}
