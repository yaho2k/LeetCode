import java.util.TreeSet;

public class H1675_MinimizeDeviationinArray {

    /*
     * Example 1: Input: nums = [1,2,3,4] Output: 1 Explanation: You can transform
     * the array to [1,2,3,2], then to [2,2,3,2], then the deviation will be 3 - 2 =
     * 1.
     * 
     * Example 2: Input: nums = [4,1,5,20,3] Output: 3 Explanation: You can
     * transform the array after two operations to [4,2,5,5,3], then the deviation
     * will be 5 - 2 = 3.
     * 
     * Example 3: Input: nums = [2,10,8] Output: 3
     */
    /*
     * [1,2,3,4] [4,1,5,20,3] [2,10,8] [1,1]
     * [399,908,648,357,693,502,331,649,596,698]
     */

    public static void main(String[] args) {
        Solution sol = new Solution();

        int arr[] = { 399, 908, 648, 357, 693, 502, 331, 649, 596, 698 };

        int result = sol.minimumDeviation(arr);
        System.out.print(result);
    }

    static class Solution {
        public int minimumDeviation(int[] nums) {
            TreeSet<Integer> ts = new TreeSet<>();
            for (int i : nums) {
                if (i % 2 == 1) {
                    i = i * 2;
                }
                ts.add(i);
            }
            int dev = Integer.MAX_VALUE;
            while (true) {
                int max = ts.last();
                dev = Math.min(dev, max - ts.first());
                if (max % 2 == 1) {
                    break;
                } else {
                    ts.remove(max);
                    ts.add(max / 2);
                }
            }
            return dev;
        }
    }
}
