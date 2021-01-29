import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class M1631_PathWithMinimumEffort {

    public static void main(String[] args) {
        int[][] heights = { { 1, 2, 3 }, { 3, 8, 4 }, { 5, 3, 5 } };

        // int[][] heights = { { 1, 2, 1, 1, 1 }, { 1, 2, 1, 2, 1 }, { 1, 2, 1, 2, 1 },
        // { 1, 2, 1, 2, 1 },
        // { 1, 1, 1, 2, 1 } };
        Solution sol = new Solution();
        int result = sol.minimumEffortPath(heights);
        System.out.print("\n" + result);
    }

    static class Solution {

        public class Heap {
            int dist;
            int row;
            int col;

            Heap(int dist, int row, int col) {
                this.dist = dist;
                this.row = row;
                this.col = col;
            }
        }

        public int minimumEffortPath(int[][] heights) {
            if (heights == null) {
                return 0;
            }
            int row = heights.length;
            int col = heights[0].length;
            int[][] dist = new int[row][col];
            for (int i = 0; i < row; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }

            PriorityQueue<Heap> minHeap = new PriorityQueue<>(Comparator.comparingInt(heap -> heap.dist));
            minHeap.offer(new Heap(0, 0, 0));

            int[] rowD = { 1, 0, 0, -1 };
            int[] colD = { 0, 1, -1, 0 };
            while (!minHeap.isEmpty()) {
                Heap heap = minHeap.poll();
                if (heap.dist > dist[heap.row][heap.col]) {
                    continue;
                }
                if (heap.row == row - 1 && heap.col == col - 1) {
                    return heap.dist;
                }
                for (int i = 0; i < 4; i++) {
                    searchHeap(heights, minHeap, heap.row, heap.col, heap.row + rowD[i], heap.col + colD[i], heap,
                            dist);
                }
            }
            return 0;
        }

        void searchHeap(int[][] heights, PriorityQueue<Heap> minHeap, int row, int col, int newRow, int newCol,
                Heap heap, int[][] dist) {
            if (newRow >= 0 && newRow < heights.length && newCol >= 0 && newCol < heights[0].length) {
                int newDist = Math.max(heap.dist, Math.abs(heights[newRow][newCol] - heights[row][col]));
                if (newDist < dist[newRow][newCol]) {
                    dist[newRow][newCol] = newDist;
                    minHeap.offer(new Heap(dist[newRow][newCol], newRow, newCol));
                }
            }
        }

        int[] DIR = new int[] { 0, 1, 0, -1, 0 };

        public int minimumEffortPath3(int[][] heights) {
            int m = heights.length, n = heights[0].length;
            int[][] dist = new int[m][n];
            for (int i = 0; i < m; i++)
                Arrays.fill(dist[i], Integer.MAX_VALUE);

            PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            minHeap.offer(new int[] { 0, 0, 0 }); // distance, row, col
            while (!minHeap.isEmpty()) {
                int[] top = minHeap.poll();
                int d = top[0], r = top[1], c = top[2];
                if (d > dist[r][c])
                    continue;
                if (r == m - 1 && c == n - 1)
                    return d; // Reach to bottom right
                for (int i = 0; i < 4; i++) {
                    int nr = r + DIR[i], nc = c + DIR[i + 1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        int newDist = Math.max(d, Math.abs(heights[nr][nc] - heights[r][c]));
                        if (dist[nr][nc] > newDist) {
                            dist[nr][nc] = newDist;
                            minHeap.offer(new int[] { dist[nr][nc], nr, nc });
                        }
                    }
                }
            }
            return 0;
        }

        public int minimumEffortPath2(int[][] heights) {

            if (heights == null) {
                return 0;
            }
            Integer[][] visited = new Integer[heights.length][heights[0].length];
            return search(heights, 0, 0, heights[0][0], visited, 0, 0);
        }

        private int search(int[][] heights, int row, int col, int before, Integer[][] visited, int k, int way) {

            if (row < 0 || col < 0 || row >= heights.length || col >= heights[0].length) {
                return Integer.MAX_VALUE;
            }

            int diff = Math.abs(heights[row][col] - before);
            if (diff > k) {
                k = diff;
            }

            if (visited[row][col] != null && k >= visited[row][col]) {
                return Integer.MAX_VALUE;
            }

            visited[row][col] = k;

            if (row == heights.length - 1 && col == heights[0].length - 1) {
                return k;
            }

            int result1 = way != 3 ? search(heights, row + 1, col, heights[row][col], visited, k, 1)
                    : Integer.MAX_VALUE;
            int result2 = way != 4 ? search(heights, row, col + 1, heights[row][col], visited, k, 2)
                    : Integer.MAX_VALUE;
            int result3 = way != 1 ? search(heights, row - 1, col, heights[row][col], visited, k, 3)
                    : Integer.MAX_VALUE;
            int result4 = way != 2 ? search(heights, row, col - 1, heights[row][col], visited, k, 4)
                    : Integer.MAX_VALUE;

            k = Math.min(Math.min(result1, result2), Math.min(result3, result4));
            return k;
        }
    }
}
