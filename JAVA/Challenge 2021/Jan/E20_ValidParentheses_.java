import java.util.Stack;

public class E20_ValidParentheses_ {
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            char[] ss = s.toCharArray();

            for (char c : ss) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.add(c);
                } else if (c == ')' || c == '}' || c == ']') {
                    if (stack.empty()){
                        return false;
                    }
                    char re = stack.pop();
                    if (c == ')') {
                        if (re != '(')
                            return false;
                    } else if (c == '}') {
                        if (re != '{')
                            return false;
                    } else if (c == ']') {
                        if (re != '[')
                            return false;
                    }
                }
            }

            return stack.empty();
        }
    }
}
