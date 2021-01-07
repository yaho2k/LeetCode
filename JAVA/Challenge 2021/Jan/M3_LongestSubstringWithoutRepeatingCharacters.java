import java.util.HashSet;

public class M3_LongestSubstringWithoutRepeatingCharacters {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int result = 0;
            int first = 0, second = 0;

            HashSet<Character> hashset = new HashSet<>();

            while (first < s.length()) {

                if (!hashset.contains(s.charAt(first))) {
                    hashset.add(s.charAt(first));
                    first++;

                    if (result < hashset.size()) {
                        result = hashset.size();
                    }
                } else {
                    hashset.remove(s.charAt(second));
                    second++;
                }
            }

            return result;
        }
    }
}
