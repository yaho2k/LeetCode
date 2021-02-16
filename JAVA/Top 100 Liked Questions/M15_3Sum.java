import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:
Input: nums = []
Output: []

Example 3:
Input: nums = [0]
Output: []

Input
[0,0,0,0]
Output
[[0,0,0],[0,0,0]]
Expected
[[0,0,0]]
*/

public class M15_3Sum {
    class Solution {
        HashMap<Integer, Integer> hash = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> threeSum(int[] nums) {

            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                hash.put(nums[i], i);
            }

            for (int i = 0; i < nums.length; i++) {
                result = twoSum(nums, -nums[i], i);
            }
            return result;
        }

        public List<List<Integer>> twoSum(int[] nums, int target, int prev) {
            Integer prevCom = null;
            if (prev > 0 && nums[prev] == nums[prev - 1]) {
                return result;
            }
            for (int i = prev + 1; i < nums.length; i++) {
                int comp = target - nums[i];
                if (prevCom != null && comp == prevCom) {
                    continue;
                }
                prevCom = comp;
                if (hash.containsKey(comp) && i < hash.get(comp)) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[prev]);
                    res.add(nums[i]);
                    res.add(comp);
                    result.add(res);
                }
            }
            return result;
        }
    }
}
