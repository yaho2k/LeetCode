import java.util.ArrayList;
import java.util.List;

public class M22_GenerateParentheses {
    class Solution {
        public List<String> generateParenthesis(int n) {

            List<String> result = new ArrayList<>();

            String sb = new String();
            if (n == 0) {
                return result;
            }

            generate(n, n, result, sb);

            return result;
        }

        private void generate(int open, int close, List<String> result, String str) {

            if(open > close){
                return;
            }
            if (open == 0 && close == 0) {
                result.add(str);
                return;
            }

            if (open > 0) {
                generate(open-1, close, result, str + "(");
            }
            if (close >0) {            
                generate(open, close-1, result, str + ")");
            }

        }
    
}
}
