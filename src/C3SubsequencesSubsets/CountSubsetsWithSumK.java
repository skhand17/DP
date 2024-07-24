package C3SubsequencesSubsets;

import java.util.Arrays;

public class CountSubsetsWithSumK {

    public static void main(String[] args) {

        int[] nums = new int[] {5, 2, 3, 10, 6, 8};
        int target =  10;

        int n = nums.length;

        int[][] dp = new int[n][target + 1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        int totalCount =  countSubsetsWithSumK(n - 1, target, nums, dp);
        System.out.println(totalCount);
    }

    private static int countSubsetsWithSumK(int index, int target, int[] nums, int[][] dp) {

        if(target == 0)
            return 1;

        if(index == 0) {
            if (nums[index] == target)
                return 1;
            else
                return 0;
        }
        if(dp[index][target] != -1){
            return dp[index][target];
        }

        int notTake = countSubsetsWithSumK(index - 1, target, nums, dp);
        int take = 0;

        if(target >= nums[index])
            take = countSubsetsWithSumK(index - 1, target - nums[index], nums, dp);

        return dp[index][target] = take + notTake;

    }
}
