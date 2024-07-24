package C3SubsequencesSubsets;

import java.util.Arrays;

public class SubsetSumEqualToTarget {

    public static void main(String[] args) {

        int[] nums = new int[] {2, 3, 1, 1};
        int target = 4;
        int[][] dp = new int[nums.length][target+1];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        boolean ans = subsetSumEqual(nums.length - 1, target, nums, dp);
        System.out.println(ans);

        boolean ans2 = subsetSumEqualTab(nums, target, nums.length);
        System.out.println(ans2);
    }

    private static boolean subsetSumEqualTab(int[] nums, int target, int index) {

        boolean[][] dp = new boolean[index][target + 1];
        for(int i=0; i<index; i++){
            dp[i][0] = true;
        }

        if(nums[0] <=target){
            dp[0][nums[0]] = true;
        }

        for(int i=1; i<index; i++) {
            for(int j=1; j<target; j++) {
                boolean notTake = dp[i-1][j];
                boolean take = false;
                if(j >= nums[i]){
                    take = dp[i-1][j - nums[i]];
                }
                dp[i][j] = take || notTake;
            }
        }
        return dp[index - 1][target];

    }

    public static boolean subsetSumEqual(int index, int target,
                                         int[] nums, int[][] dp) {

        if(target == 0)
            return true;

        if(index == 0)
            return nums[index] == target;

        if(dp[index][target] != -1){
            return dp[index][target] == 0 ? false : true;
        }

        boolean notTake = subsetSumEqual(index - 1, target, nums, dp);
        boolean take = false;

        if(target >= nums[index]){
            take = subsetSumEqual(index - 1, target - nums[index], nums, dp);
        }
        dp[index][target] = notTake || take ? 1 : 0;
        return take || notTake;
    }
}
