public class E283_MoveZeroes {
    class Solution {
        public void moveZeroes(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }

            int posOrg = 0;
            int posNew = 0;
            while (posOrg < nums.length) {

                if (nums[posOrg] != 0) {
                    nums[posNew] = nums[posOrg];
                    posNew++;
                }
                posOrg++;
            }

            while (posNew < nums.length) {
                nums[posNew] = 0;
                posNew++;
            }

        }
    }
}
