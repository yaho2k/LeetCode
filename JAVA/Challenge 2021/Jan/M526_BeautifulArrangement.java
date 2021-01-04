public class M526_BeautifulArrangement {
    class Solution {
        private int count = 0;
        public int countArrangement(int N) {
            boolean[] visited = new boolean[N + 1];
            permute(N, 1, visited);
            return count;
        }
    
        private void permute(int N, int pos, boolean[] visited) {
            if (pos > N) {
                count++;
            }
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && (i % pos == 0 || pos % i == 0)) {
                    visited[i] = true;
                    permute(N, pos + 1, visited);
                    visited[i] = false;
                }
            }
        }
    }
}
