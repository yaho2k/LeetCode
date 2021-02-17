import java.util.ArrayList;
import java.util.List;

public class M17_LetterCombinationsofaPhoneNumber {

    /*
     * Example 1: Input: digits = "23" Output:
     * ["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * 
     * Example 2: Input: digits = "" Output: []
     * 
     * Example 3: Input: digits = "2" Output: ["a","b","c"]
     */

    /*
     * abc def ghi jkl mno pqrs tuvw xyz
     */

     public static void main(String[] args) {
         Solution sol = new Solution();
         List<String> result = sol.letterCombinations("23");

         System.out.print(result);

     }
    static class Solution {

        char phones[][] = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
                { 'm', 'n', 'o' },  { 'p', 'q', 'r', 's' }, { 't', 'u', 'v', 'w' },
                { 'x', 'y', 'z' } };
        List<String> results = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if(digits == null || digits.length() == 0){
                return results;
            }
            char[] digs = digits.toCharArray();
            backtracking("", digs, 0);
            return results;
        }

        private void backtracking(String phone, char[] digs, int index) {
            if (index >= digs.length) {
                results.add(phone);
                return;
            }
            int phoneIndex = digs[index] - '0';
            index++;
            for (int i = 0; i < phones[phoneIndex].length; i++) {
                StringBuffer bf = new StringBuffer();
                bf.append(phone).append(phones[phoneIndex][i]);
                backtracking(bf.toString(), digs, index);
            }
        }
    }
}