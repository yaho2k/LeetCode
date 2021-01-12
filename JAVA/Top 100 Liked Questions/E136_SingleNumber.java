import java.util.HashSet;

public class E136_SingleNumber {
    class Solution {
        public int singleNumber(int[] nums) {
            HashSet<Integer> hashset = new HashSet<>();

            for (int i = 0; i < nums.length; i++) {
                if (hashset.contains(nums[i])) {
                    hashset.remove(nums[i]);
                } else {
                    hashset.add(nums[i]);
                }
            }
            for (int i : hashset) {
                return i;
            }
            return 0;
        }
    }
}
