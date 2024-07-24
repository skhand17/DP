package OneDP;

import java.util.Arrays;

public class HouseRobberII  {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp1 = new int[nums.length - 1];
        int[] dp2 = new int[nums.length - 1];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        return Math.max(robHelper(nums, 0, nums.length - 2, dp1),
                robHelper(nums, 1, nums.length - 1, dp2));
    }

    private int robHelper(int[] nums, int start, int end, int[] dp) {
        if (start > end) {
            return 0;
        }

        if (start == end) {
            return nums[start];
        }

        int index = start - (end == nums.length - 1 ? 1 : 0);
        if (dp[index] != -1) {
            return dp[index];
        }

        int rob = nums[start] + robHelper(nums, start + 2, end, dp);
        int skip = robHelper(nums, start + 1, end, dp);

        dp[index] = Math.max(rob, skip);
        return dp[index];
    }
}
