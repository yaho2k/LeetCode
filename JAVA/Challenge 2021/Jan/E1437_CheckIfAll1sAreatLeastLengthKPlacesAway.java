public class E1437_CheckIfAll1sAreatLeastLengthKPlacesAway {

    /*
     * Example 1: Input: nums = [1,0,0,0,1,0,0,1], k = 2 Output: true Explanation:
     * Each of the 1s are at least 2 places away from each other.
     * 
     * Example 2: Input: nums = [1,0,0,1,0,1], k = 2 Output: false Explanation: The
     * second 1 and third 1 are only one apart from each other.
     * 
     * Example 3: Input: nums = [1,1,1,1,1], k = 0 Output: true
     * 
     * Example 4: Input: nums = [0,1,0,1], k = 1 Output: true
     */

    class Solution {
        public boolean kLengthApart(int[] nums, int k) {
            if (nums == null) {
                return false;
            }

            if (k == 0) {
                return true;
            }

            int zero = 0;
            int start = 0;
            while (start < nums.length && nums[start] == 1) {
                if (start > 0) {
                    return false;
                }
                start++;
            }

            for (int i = start; i < nums.length; i++) {
                if (nums[i] == 0) {
                    zero++;
                } else {
                    if (zero < k) {
                        return false;
                    } else {
                        zero = 0;
                    }
                }
            }

            return true;
        }
    }
}
