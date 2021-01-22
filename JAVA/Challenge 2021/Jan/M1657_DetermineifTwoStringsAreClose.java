import java.util.HashSet;
import java.util.Set;

public class M1657_DetermineifTwoStringsAreClose {

    /*
     * Example 1: Input: word1 = "abc", word2 = "bca" Output: true Explanation: You
     * can attain word2 from word1 in 2 operations. Apply Operation 1: "abc" ->
     * "acb" Apply Operation 1: "acb" -> "bca"
     * 
     * Example 2: Input: word1 = "a", word2 = "aa" Output: false Explanation: It is
     * impossible to attain word2 from word1, or vice versa, in any number of
     * operations.
     * 
     * Example 3: Input: word1 = "cabbba", word2 = "abbccc" Output: true
     * Explanation: You can attain word2 from word1 in 3 operations. Apply Operation
     * 1: "cabbba" -> "caabbb" Apply Operation 2: "caabbb" -> "baaccc" Apply
     * Operation 2: "baaccc" -> "abbccc"
     * 
     * Example 4: Input: word1 = "cabbba", word2 = "aabbss" Output: false
     * Explanation: It is impossible to attain word2 from word1, or vice versa, in
     * any amount of operations.
     */

    public static void main(String[] args) {
        Solution sol = new Solution();
        String word1 = "uau";
        String word2 = "ssx";
        boolean result = sol.closeStrings(word1, word2);
        System.out.print(result);
    }

    /*
     * "uau" "ssx"
     */
    static class Solution {
        public boolean closeStrings(String word1, String word2) {
            int[] freq1 = new int[26];
            int[] freq2 = new int[26];

            Set<Character> set1 = new HashSet<>();
            Set<Character> set2 = new HashSet<>();

            for (char c : word1.toCharArray()) {
                freq1[c - 'a']++;
                set1.add(c);
            }

            for (char c : word2.toCharArray()) {
                freq2[c - 'a']++;
                set2.add(c);
            }

            Set<Integer> freqSet1 = new HashSet<>();
            Set<Integer> freqSet2 = new HashSet<>();

            for (int freq : freq1) {
                freqSet1.add(freq);
            }

            for (int freq : freq2) {
                freqSet2.add(freq);
            }

            return set1.equals(set2) && freqSet1.equals(freqSet2);
        }
    }
}
