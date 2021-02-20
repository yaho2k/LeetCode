import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M56_MergeIntervals {

    /*
     * Example 1: Input: intervals = [[1,3],[2,6],[8,10],[15,18]] Output:
     * [[1,6],[8,10],[15,18]] Explanation: Since intervals [1,3] and [2,6] overlaps,
     * merge them into [1,6].
     * 
     * Example 2: Input: intervals = [[1,4],[4,5]] Output: [[1,5]] Explanation:
     * Intervals [1,4] and [4,5] are considered overlapping.
     */
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] nums = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 }, { 17, 19 } };
        int[][] result = sol.merge(nums);
        System.out.print(result);
    }

    static class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            List<int[]> result = new ArrayList<>();
            int index = 0;
            int[] tmp = intervals[0];
            result.add(tmp);
            for (int i = 0; i + 1 < intervals.length; i++) {
                if (intervals[index][1] >= intervals[i + 1][0]) {
                    tmp[1] = Math.max(intervals[index][1], intervals[i + 1][1]);
                } else {
                    index = i + 1;
                    tmp = intervals[index];
                    result.add(tmp);
                }
            }
            return result.toArray(new int[result.size()][]);
        }
    }

}
