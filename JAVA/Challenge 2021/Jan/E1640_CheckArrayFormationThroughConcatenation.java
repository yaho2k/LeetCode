import java.util.HashMap;

public class E1640_CheckArrayFormationThroughConcatenation {

    /*
     * Example 1: Input: arr = [85], pieces = [[85]] Output: true
     * 
     * Example 2: Input: arr = [15,88], pieces = [[88],[15]] Output: true
     * Explanation: Concatenate [15] then [88]
     * 
     * Example 3: Input: arr = [49,18,16], pieces = [[16,18,49]] Output: false
     * Explanation: Even though the numbers match, we cannot reorder pieces[0].
     * 
     * Example 4: Input: arr = [91,4,64,78], pieces = [[78],[4,64],[91]] Output:
     * true Explanation: Concatenate [91] then [4,64] then [78]
     * 
     * Example 5: Input: arr = [1,3,5,7], pieces = [[2,4,6,8]] Output: false
     */
    /*
     * [49,18,16] [[16,18,49]]
     */

    public static void main(String[] args) {
        Solution sol = new Solution();

        int arr[] = { 49, 18, 16 };
        int pieces[][] = { { 16, 18, 49 } };

        boolean result = sol.canFormArray(arr, pieces);
        System.out.print(result);
    }

    static class Solution {
        public boolean canFormArray(int[] arr, int[][] pieces) {

            HashMap<Integer, Integer> set = new HashMap<>();

            for (int i = 0; i < arr.length; i++) {
                set.put(arr[i], i);
            }

            for (int[] piece : pieces) {
                if (set.containsKey(piece[0])) {
                    int value = set.get(piece[0]);
                    for (int i = 0; i < piece.length; i++) {
                        if (value >= arr.length) {
                            return false;
                        }
                        if (arr[value] != piece[i]) {
                            return false;
                        }
                        value++;
                    }
                } else {
                    return false;
                }
            }
            return true;

        }
    }
}
