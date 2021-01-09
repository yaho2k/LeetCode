public class E1662_CheckIfTwoStringArraysareEquivalent {
    /*
     * Example 1: Input: word1 = ["ab", "c"], word2 = ["a", "bc"] 
     * Output: true
     * Explanation: word1 represents string "ab" + "c" -> "abc" word2 represents
     * string "a" + "bc" -> "abc" The strings are the same, so return true.
     * 
     * Example 2: Input: word1 = ["a", "cb"], word2 = ["ab", "c"] 
     * Output: false
     * 
     * Example 3: Input: word1 = ["abc", "d", "defg"], word2 = ["abcddefg"] 
     * Output: true
     */

    class Solution {

        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

            StringBuffer wordS1 = new StringBuffer();
            StringBuffer wordS2 = new StringBuffer();
            for (String word : word1) {
                wordS1.append(word);
            }

            for (String word : word2) {
                wordS2.append(word);
            }

            if (wordS1.toString().equals(wordS2.toString())) {
                return true;
            }

            return false;
        }
    }
}
