import java.util.Stack;

public class E155_MinStack {
    class MinStack {

        Stack<Integer> stack;
        Stack<Integer> minStack;
    
        /** initialize your data structure here. */
        MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }
    
        public void push(int x) {
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
            stack.push(x);
        }
    
        public void pop() {
    
            int x = stack.pop();
            if (x == minStack.peek()) {
                minStack.pop();
            }
        }
    
        public int top() {
            return stack.peek();
        }
    
        public int getMin() {
            return minStack.peek();
        }
    }
    
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}
