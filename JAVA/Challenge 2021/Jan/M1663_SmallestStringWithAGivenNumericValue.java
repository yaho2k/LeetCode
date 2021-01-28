public class M1663_SmallestStringWithAGivenNumericValue {

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        String result = sol.getSmallestString(5,    73);
        System.out.print("result " + result);
    }
    /*
     * Example 1: 
     * Input: n = 3, k = 27 Output: "aay" 
     * Explanation: The numeric value
     * of the string is 1 + 1 + 25 = 27, and it is the smallest string with such a
     * value and length equal to 3.
     * 
     * Example 2: 
     * Input: n = 5, k = 73 Output: "aaszz"
     */
    static class Solution {
        public String getSmallestString(int n, int k) {
    
                int[] result = new int[n];
                int index = n - 1;
                int start = 26;
    
                while (true) {
                    if(index < 0 || k == 0){
                        break;
                    }
                    if (k - start >= index) {
                        result[index--] = start;
                        k = k - start;
                    }else{
                        start--;
                    }
                }
    
                char [] results = new char[n];
                int ci =0;
                for (int i : result) {
                    results [ci++]=(char)(i + 'a' - 1);                
                }
    
                return String.valueOf(results);
        }
    }
}
