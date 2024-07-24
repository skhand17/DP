package Knapsack;

public class MinCoinsPractice {

    public static void main(String[] args) {

        int[] coins = new int[]{2, 5, 10, 1};
        int target =  27;

        int minCoins = minimumCoins(coins, coins.length - 1, target);
        System.out.println(minCoins);
    }

    private static int minimumCoins(int[] coins, int index, int target) {

        if(index == 0){
            if(target % coins[0] == 0){
                return target / coins[index];
            } else {
                return Integer.MAX_VALUE;
            }
        }
        int pick = Integer.MAX_VALUE;
        int notPick = minimumCoins(coins, index - 1, target);

        if(coins[index] <= target){
            pick = 1 + minimumCoins(coins, index, target - coins[index]);
        }
        return Math.min(pick, notPick);
    }
}
