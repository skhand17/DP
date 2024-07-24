package C3SubsequencesSubsets;

import java.util.Arrays;

public class TargetSumDP {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 1};
        int totalSum = 0;
        int target = 3;
        for(int num : nums){
            totalSum += num;
        }

        int targetSum = (totalSum - target)/2;
        int[][] dp = new int[nums.length][targetSum + 1];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        int countWays = countWays(nums, targetSum, nums.length - 1, dp);
        System.out.println(countWays);
    }

    public static int countWays(int[] nums, int target, int index, int[][] dp) {

        if(target == 0)
            return 1;

        if(index == 0) {
            if(target == nums[index])
                return 1;
            else
                return 0;
        }
        if(dp[index][target] != -1)
            return dp[index][target];

        int notTake = countWays(nums, target, index - 1, dp);
        int take = 0;

        if(target >= nums[index]){
            take = countWays(nums, target - nums[index], index - 1, dp);
        }
        return dp[index][target] = take + notTake;

    }
}
