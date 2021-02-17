import java.util.ArrayList;
import java.util.List;

/* Example 1:
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

Example 4:
Input: candidates = [1], target = 1
Output: [[1]]

Example 5:
Input: candidates = [1], target = 2
Output: [[1,1]] */

public class M39_CombinationSum {

    class Solution {
        List<List<Integer>> results = new ArrayList<>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            
            if(candidates == null){
                return results;
            }
            backtracking(candidates, target, new ArrayList<>(), 0);
            return results;
        }

        private void backtracking(int[] candidates, int remain, List<Integer> list, int start) {
            
            if(remain < 0){
                return;
            }
            if(remain == 0){
                results.add(new ArrayList<>(list));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                backtracking(candidates, remain - candidates[i], list, i);
                list.remove(list.size() - 1);
            }

        }
    }
}
