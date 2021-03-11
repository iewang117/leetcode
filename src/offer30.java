import java.util.Stack;

public class offer30 {
    class MinStack {
        Stack<Integer> dataStack;
        Stack<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            dataStack = new Stack<Integer>();
            minStack = new Stack<Integer>();
        }

        public void push(int x) {
            dataStack.push(x);
            minStack.push(minStack.isEmpty() ? x : Math.min(x, minStack.peek()));
        }

        public void pop() {
            dataStack.pop();
            minStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
}
