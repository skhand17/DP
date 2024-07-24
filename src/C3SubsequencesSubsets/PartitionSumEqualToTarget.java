package C3SubsequencesSubsets;

import java.util.Arrays;

public class PartitionSumEqualToTarget {

    public static void main(String[] args) {

        int[] nums = new int[] {1, 2, 3, 5};
        int n = nums.length;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        boolean ans = paritionSum(nums, sum, n);
        System.out.println(ans);

    }

    public static boolean paritionSum(int[] nums, int sum, int n) {

        if(sum % 2 != 0)
            return false;

        int target = sum / 2;

        int[][]dp = new int[n][target + 1];
        for(int[] row : dp)
            Arrays.fill(row, -1);

      return paritionSumEqualTarget(n - 1, target, nums, dp);


    }

    private static boolean paritionSumEqualTarget(int index, int target, int[] nums, int[][] dp) {

        if(target == 0)
            return true;

        if(index == 0)
            return nums[0] == target;

        if(dp[index][target] != -1) {
            return dp[index][target] == 1 ? true : false;
        }

        boolean notTake = paritionSumEqualTarget(index - 1, target, nums, dp);
        boolean take = false;

        if(target >= nums[index])
            take = paritionSumEqualTarget(index - 1, target - nums[index], nums, dp);

        dp[index][target] = take || notTake ? 1 : 0;
        return take || notTake;
    }
}
