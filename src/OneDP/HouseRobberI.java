package OneDP;

import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;

public class HouseRobberI {

    public static void main(String[] args) {

        int[] nums = new int[] {2, 7, 9, 3, 1};
        int ans = rob(nums);
        System.out.println(ans);
    }

    public static int rob(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp , -1);
        int maximize = maximumRob(n - 1, nums, dp);
        return maximize;
    }

    private static int maximumRob(int index, int[] nums, int[] dp) {

        if(index == 0){
            return nums[0];
        }

        if(index < 0){
            return 0;
        }

        if(dp[index] != -1){
            return dp[index];
        }

        int pick = nums[index] + maximumRob(index - 2, nums, dp);
        int notPick = maximumRob(index - 1, nums, dp);

        return dp[index] = Math.max(pick, notPick);
    }
}
