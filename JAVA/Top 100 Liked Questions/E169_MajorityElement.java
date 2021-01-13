import java.util.HashMap;

public class E169_MajorityElement {

    /*
     * Example 1: Input: nums = [3,2,3] Output: 3
     * 
     * Example 2: Input: nums = [2,2,1,1,1,2,2] Output: 2
     */

    class Solution {
        public int majorityElement(int[] nums) {

            if (nums == null) {
                return -1;
            }
            HashMap<Integer, Integer> hash = new HashMap<>();

            int maxID = 0;
            int max = 0;
            for (int i : nums) {
                if (hash.get(i) != null) {
                    hash.put(i, hash.get(i) + 1);
                } else {
                    hash.put(i, 1);
                }
                if (hash.get(i) > max) {
                    maxID = i;
                    max = hash.get(i);
                }
            }

            return maxID;
        }
    }
}
