package BackTracking;

import java.util.ArrayList;
import java.util.List;

/*
* Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
*
* */
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;

        List<List<Integer>> result = combinationSum(candidates, target);
        for(List<Integer> innerLists : result){
            System.out.println(innerLists);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ds = new ArrayList<>();
        findCombinations(0, candidates, target, ds, new ArrayList<>());

        return ds;

    }

    public static void findCombinations(int index, int[]candidates,
                                        int target,
                                        List<List<Integer>> result, List<Integer> innerList) {

//        base case
//        if(index == candidates.length){
//            if (target == 0){
//                result.add(new ArrayList<>(innerList));
//            } else
//                return;
//        }
        if (target == 0) {
            result.add(new ArrayList<>(innerList));
            return;
        }

        if (index == candidates.length || target < 0) {
            return;
        }

        if(candidates[index] <= target){
            innerList.add(candidates[index]);
            findCombinations(index, candidates, target - candidates[index],
                    result, innerList);
            innerList.remove(innerList.size() - 1);
        }

        findCombinations(index+1, candidates, target, result, innerList);

    }
}
