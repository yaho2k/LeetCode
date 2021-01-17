public class M1641_CountSortedVowelStrings {

    /*
     * Example 1: Input: n = 1 Output: 5 Explanation: The 5 sorted strings that
     * consist of vowels only are ["a","e","i","o","u"].
     * 
     * Example 2: Input: n = 2 Output: 15 Explanation: The 15 sorted strings that
     * consist of vowels only are ["aa","ae","ai","ao","au", "ee","ei","eo","eu",
     * "ii","io","iu", "oo","ou", "uu"].
     * 
     * Note that "ea" is not a valid string since 'e' comes after 'a' in the
     * alphabet.
     * 
     * Example 3: Input: n = 33 Output: 66045
     */

    /*
     * 1 1 1 1 1 5 4 3 2 1 15 10 6 3 1
     */

    /*
     * 1 1 1 1 1 1 2 3 4 5 1 3 6 10 15
     */

    class Solution {
        public int countVowelStrings(int n) {
            if (n == 1) {
                return 5;
            }

            int[][] table = new int[n][5];
            for (int i = 0; i < 5; i++) {
                table[0][i] = 1;
            }

            int sum = 5;
            int result = find(n, 1, sum, table);
            return result;
        }

        private int find(int n, int num, int sum, int[][] table) {

            if (num >= n) {
                return sum;
            }

            table[num][0] = 1;
            sum = table[num][0];
            for (int i = 1; i < 5; i++) {
                table[num][i] = table[num - 1][i] + table[num][i - 1];
                sum += table[num][i];
            }

            sum = find(n, num + 1, sum, table);

            return sum;
        }

    }
}
