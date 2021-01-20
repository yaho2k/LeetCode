import java.util.HashMap;

public class M1679_MaxNumberofKSumPairs {

    /*
     * Example 1: Input: nums = [1,2,3,4], k = 5 Output: 2 Explanation: Starting
     * with nums = [1,2,3,4]: - Remove numbers 1 and 4, then nums = [2,3] - Remove
     * numbers 2 and 3, then nums = [] There are no more pairs that sum up to 5,
     * hence a total of 2 operations.
     * 
     * Example 2: Input: nums = [3,1,3,4,3], k = 6 Output: 1 Explanation: Starting
     * with nums = [3,1,3,4,3]: - Remove the first two 3's, then nums = [1,4,3]
     * There are no more pairs that sum up to 6, hence a total of 1 operation.
     */

    /*
     * Input: [3,1,3,4,3] 6 Output: 0 Expected: 1
     */

    /*
     * Input: [4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4] 2 Output: 0 Expected: 2
     */
    public static void main(String[] args) {
        Solution sol = new Solution();

        int arr[] = { 4, 4, 1, 3, 1, 3, 2, 2, 5, 5, 1, 5, 2, 1, 2, 3, 5, 4 };

        int result = sol.maxOperations(arr, 2);
        System.out.print(result);
    }

    static class Solution {
        public int maxOperations(int[] nums, int k) {

            int operation = 0;
            HashMap<Integer, Integer> hash = new HashMap<>();

            for (int i : nums) {
                hash.put(i, hash.getOrDefault(i, 0) + 1);
            }

            for (int i : hash.keySet()) {
                if (i * 2 == k) {
                    operation += hash.get(i) / 2;
                } else if (hash.containsKey(k - i)) {
                    int min = Math.min(hash.get(i), hash.get(k - i));
                    operation += min;
                    hash.put(i, hash.get(i) - min);
                    hash.put(k - i, hash.get(k - i) - min);
                }
            }

            return operation;
        }
    }
}
