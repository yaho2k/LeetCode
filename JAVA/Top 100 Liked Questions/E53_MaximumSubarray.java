public class E53_MaximumSubarray {

    /*
     * Example 1: Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6 Explanation:
     * [4,-1,2,1] has the largest sum = 6.
     * 
     * Example 2: Input: nums = [1] Output: 1
     * 
     * Example 3: Input: nums = [0] Output: 0
     * 
     * Example 4: Input: nums = [-1] Output: -1
     * 
     * Example 5: Input: nums = [-2147483647] Output: -2147483647
     */

    class Solution {
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length];
            int max = nums[0];
            dp[0] = nums[0];

            for (int i = 1; i < nums.length; i++) {

                if (dp[i - 1] < 0) {
                    dp[i] = nums[i];
                } else {
                    dp[i] = dp[i - 1] + nums[i];
                }
                if (dp[i] > max) {
                    max = dp[i];
                }
            }
            return max;
        }
    }
}
