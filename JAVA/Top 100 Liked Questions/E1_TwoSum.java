import java.util.HashMap;

public class E1_TwoSum {

    public static void main(String[] args) {
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
            HashMap<Integer, Integer> hashmap = new HashMap<>();
            hashmap.put(nums[0], 0);

            for (int i = 1; i < nums.length; i++) {
                if (hashmap.containsKey(target - nums[i])) {
                    int value = hashmap.get(target - nums[i]);

                    if (i < value) {
                        result[0] = i;
                        result[1] = value;
                    } else {
                        result[0] = value;
                        result[1] = i;
                    }

                    break;
                }
                hashmap.put(nums[i], i);
            }

            return result;
        }
    }
}
