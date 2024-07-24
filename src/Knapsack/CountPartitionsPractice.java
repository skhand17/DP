package Knapsack;

public class CountPartitionsPractice {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 6, 4};
        int difference = 3;
        int totalSum = 0;
        for(int i: arr){
            totalSum += i;
        }

//        s1 + s2 =  totalSum
//        s1 - s2 = difference
//        totalSum - s2 - s2 = difference
//        2s2 = totalSum - difference
//        s2 = totalSum - difference / 2;


        int targetSum =  (totalSum - difference) / 2;

        int countPartitions = countPartitions(arr, arr.length - 1, targetSum);
        System.out.println(countPartitions);

    }

    public static int countPartitions(int[] arr, int index, int targetSum) {

        if(targetSum == 0){
            return 1;
        }

        if(index == 0){
            if(arr[index] == targetSum)
                return 1;
            else
                return 0;
        }

        int notTake = countPartitions(arr, index - 1, targetSum);
        int take = 0;
        if(arr[index] <= targetSum){
            take = countPartitions(arr, index - 1, targetSum - arr[index]);
        }

        return take + notTake;
    }
}
