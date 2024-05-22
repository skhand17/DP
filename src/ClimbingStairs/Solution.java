package ClimbingStairs;

public class Solution {

    public static void main(String[] args) {


        int numberOfStairs = 3;
        System.out.println(findNoOfWays(3));
    }


    public  static int findNoOfWays(int numberOfStairs) {

        if(numberOfStairs == 0)
            return 1;
        if(numberOfStairs == 1)
            return 1;

        int left = findNoOfWays(numberOfStairs-1);
        int right = findNoOfWays(numberOfStairs - 2);

        return left + right;
    }
}
