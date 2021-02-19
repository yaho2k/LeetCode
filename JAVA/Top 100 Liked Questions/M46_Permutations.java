import java.util.ArrayList;
import java.util.List;

public class M46_Permutations {
    class Solution {
        List<List<Integer>> results = new ArrayList<>();
        public List<List<Integer>> permute(int[] nums) {
            if (nums == null) {
                return results;
            }
            backtracking(nums, new ArrayList<>(), 0);
            return results;
        }

        private void backtracking(int[] candidates, List<Integer> list, int index) {

            if (candidates.length <= index) {
                results.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < candidates.length; i++) {
                if (list.contains(candidates[i])) {
                    continue;
                }
                list.add(candidates[i]);
                backtracking(candidates, list, index + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
