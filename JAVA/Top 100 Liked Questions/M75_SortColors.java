public class M75_SortColors {
    /*
     * Example 1: Input: nums = [2,0,2,1,1,0] Output: [0,0,1,1,2,2]
     * 
     * Example 2: Input: nums = [2,0,1] Output: [0,1,2]
     * 
     * Example 3: Input: nums = [0] Output: [0]
     * 
     * Example 4: Input: nums = [1] Output: [1]
     */

    class Solution {
        public void sortColors(int[] nums) {

            int num1 = 0, num2 = 0, num3 = 0;
            for (int i : nums) {
                if (i == 0) {
                    num1++;
                } else if (i == 1) {
                    num2++;
                } else {
                    num3++;
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (num1 != 0) {
                    nums[i] = 0;
                    num1--;
                } else if (num2 != 0) {
                    nums[i] = 1;
                    num2--;
                } else if (num3 != 0) {
                    nums[i] = 2;
                    num3--;
                }

            }
        }
    }
}
