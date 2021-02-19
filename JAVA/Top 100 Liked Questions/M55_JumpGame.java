public class M55_JumpGame {

    /*
     * Example 1: Input: nums = [2,3,1,1,4] Output: true Explanation: Jump 1 step
     * from index 0 to 1, then 3 steps to the last index.
     * 
     * Example 2: Input: nums = [3,2,1,0,4] Output: false Explanation: You will
     * always arrive at index 3 no matter what. Its maximum jump length is 0, which
     * makes it impossible to reach the last index.
     */

    /* [2,3,1,1,4]
    [3,2,1,0,4]
    [1,0]
    [0]
    [1]
    [0,1]
    [2,0]
     */

    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] nums = { 2,1,0,1,4};
        boolean result = sol.canJump(nums);
        System.out.print(result);
    }
    static class Solution {
        int[] map;
        public boolean canJump(int[] nums) {

            if (nums == null || nums.length == 0) {
                return false;
            }

            map = new int[nums.length];
            return canJumpGreed(nums, 0);
        }

        private boolean canJumpGreed(int[] nums, int index) {

            boolean result = false;
            if (index >= nums.length - 1) {
                return true;
            }

            if (nums[index] == 0) {
                return false;
            }

            for (int i = nums[index]; i > 0; i--) {
                if(index +i >= nums.length-1){
                    return true;
                }
                if(map[index +i] == -1){
                    continue;
                }
                result = canJumpGreed(nums, index + i );
                if (result) {
                    return true;
                }else{
                    map[index +i] = -1;
                }
            }

            return result;

        }

    }

}
