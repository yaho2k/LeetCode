public class E1539_KthMissingPositiveNumber {

    /*
     * Example 1: Input: arr = [2,3,4,7,11], k = 5 Output: 9 Explanation: The
     * missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing
     * positive integer is 9.
     * 
     * Example 2: Input: arr = [1,2,3,4], k = 2 Output: 6 Explanation: The missing
     * positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
     */

    static class Solution {

        public int findKthPositive(int[] arr, int k) {

            for (int i = 0; i < arr.length; i++) {
                int x = arr[i] - (i + 1);
                if (x >= k)
                    return i + k;
            }
            return arr.length + k;
        }
    }
}
