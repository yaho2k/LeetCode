public class M64_MinimumPathSum {

    /*
     * Example 1: Input: grid = [[1,3,1],[1,5,1],[4,2,1]] Output: 7 Explanation:
     * Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
     * 
     * Example 2: Input: grid = [[1,2,3],[4,5,6]] Output: 12
     * 
     * input [[0]] Output 2147483647 Expected 0
     */
    class Solution {
        public int minPathSum(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int[][] map = new int[grid.length][grid[0].length];
            for (int i = 1; i < grid.length; i++) {
                for (int j = 1; j < grid[0].length; j++) {
                    map[i][j] = Integer.MAX_VALUE;
                }
            }
            map[0][0] = grid[0][0];
            for (int i = 1; i < grid.length; i++) {
                grid[i][0] = grid[i - 1][0] + grid[i][0];
                map[i][0] = grid[i][0];
            }

            for (int i = 1; i < grid[0].length; i++) {
                grid[0][i] = grid[0][i - 1] + grid[0][i];
                map[0][i] = grid[0][i];
            }

            for (int i = 1; i < grid.length; i++) {
                for (int j = 1; j < grid[0].length; j++) {
                    map[i][j] = Math.min(map[i - 1][j], map[i][j - 1]) + grid[i][j];
                }
            }

            return map[grid.length - 1][grid[0].length - 1];
        }
    }
}
