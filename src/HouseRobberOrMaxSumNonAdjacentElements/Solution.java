package HouseRobberOrMaxSumNonAdjacentElements;

import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] arr = new int[] {2, 7, 9, 3, 1};
        int[] dp  = new int[arr.length];
        Arrays.fill(dp, -1);

        int ans = houseRobberMemoization(arr.length - 1, arr, dp);
        System.out.println(ans);

        int ans2 = houseRobberSpaceOptimization(arr.length -1, arr);
        System.out.println(ans2);
    }

    /*
    * TC : O(n)
    * SC : o(N) + O(N)
    *
    * */

    public static int houseRobberMemoization(int index, int[] arr, int [] dp) {

        if(index == 0){
            return arr[index];
        }

        if(index < 0)
            return 0;


        if(dp[index] != -1){
            return dp[index];
        }

        int pick = arr[index] + houseRobberMemoization(index - 2, arr, dp);
        int notPick = 0 + houseRobberMemoization(index - 1, arr, dp);

        return dp[index] = Math.max(pick, notPick);
    }

    public static int houseRobberSpaceOptimization(int index, int[] arr) {
        int previous = arr[0];
        int previous2 = 0;


        for(int i=1; i<=index; i++){

            int pick = arr[i];
            if(i > 1){
                pick += previous2;
            }
            int notpick = previous;

            int currentI = Math.max(pick, notpick);
            previous2 = previous;
            previous = currentI;
        }

        return previous;
    }
}
