import java.util.HashMap;

public class M5_LongestPalindromicSubstring {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "babad";
        String result = sol.longestPalindrome(s);
        System.out.print(result);
    }

    /*
     * Example 1: Input: s = "babad" Output: "bab" Note: "aba" is also a valid
     * answer.
     * 
     * Example 2: Input: s = "cbbd" Output: "bb"
     * 
     * Example 3: Input: s = "a" Output: "a"
     * 
     * Example 4: Input: s = "ac" Output: "a"
     */
    static class Solution {
        public String longestPalindrome(String s) {
            char[] schar = s.toCharArray();

            int max = 0;
            String maxString = "";
            int tmp;
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < s.length(); j++) {
                    if (j < i) {
                        continue;
                    }
                    if( j - i < max){
                        continue;
                    }
                    tmp = check1(schar, i, j);
                    if (tmp != 0 && tmp > max) {
                        max = tmp;
                        StringBuffer sb = new StringBuffer();
                        for (int k = i; k <= j; k++) {
                            sb.append(schar[k]);
                        }
                        maxString = sb.toString();
                    }
                }
            }
            return maxString;
        }

        private int check1(char[] schar, int start, int end) {
            if (start > end) {
                return 0;
            }
            int length = end - start + 1;
            for (int i = 0; i < (length) / 2; i++) {
                if (schar[start + i] != schar[start + length - 1 - i]) {
                    return 0;
                }
            }
            return end - start + 1;
        }

        private String check(char[] schar, int start, int end) {
            if (start > end) {
                return "";
            }
            int length = end - start + 1;
            for (int i = 0; i < (length) / 2; i++) {
                if (schar[start + i] != schar[start + length - 1 - i]) {
                    return "";
                }
            }
            String result;
            StringBuffer sb = new StringBuffer();
            for (int i = start; i <= end; i++) {
                sb.append(schar[i]);
            }
            return sb.toString();

        }
    }
}
