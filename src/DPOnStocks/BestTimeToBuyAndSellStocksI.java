package DPOnStocks;

public class BestTimeToBuyAndSellStocksI {

    public static void main(String[] args) {


        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        int n = arr.length;
        int profitMax = maxProfit(arr, n);
        System.out.println(profitMax);
    }

    public static int maxProfit(int[]arr, int n) {

        int mini = arr[0];
        int profit = 0;

        for(int i=1; i<n; i++) {
            int cost = arr[i] - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, arr[i]);
        }
        return profit;
    }

}
