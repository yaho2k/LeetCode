public class M62_UniquePaths {

  /*
   * Example 1: Input: m = 3, n = 7 Output: 28
   * 
   * Example 2: Input: m = 3, n = 2 Output: 3 Explanation: From the top-left
   * corner, there are a total of 3 ways to reach the bottom-right corner: 1.
   * Right -> Down -> Down 2. Down -> Down -> Right 3. Down -> Right -> Down
   * 
   * Example 3: Input: m = 7, n = 3 Output: 28
   * 
   * Example 4: Input: m = 3, n = 3 Output: 6
   */

  class Solution {

    public int uniquePaths(int m, int n) {
      int[][] grid = new int[n][m];

      for (int i = 0; i < n; i++) {
        grid[i][0] = 1;
      }

      for (int i = 0; i < m; i++) {
        grid[0][i] = 1;
      }

      for (int i = 1; i < n; i++) {
        for (int j = 1; j < m; j++) {
          grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
        }
      }
      return grid[n - 1][m - 1];
    }

    public int uniquePaths2(int m, int n) {

      return dp(m - 1, n - 1, new int[m][n]);
    }

    private int dp(int i, int j, int[][] memo) {

      if (i == 0 && j == 0) {
        return 1;
      } else if (i < 0 || j < 0) {
        return 0;
      } else if (memo[i][j] > 0) {
        return memo[i][j];
      } else {
        memo[i][j] = dp(i, j - 1, memo) + dp(i - 1, j, memo);
        return memo[i][j];
      }

    }
  }
}
