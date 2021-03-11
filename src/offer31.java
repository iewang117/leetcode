import java.util.Stack;

public class offer31 {
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<Integer>();
            for(int i = 0, j = 0; i < pushed.length; i++){
                stack.push(pushed[i]);
                while(!stack.isEmpty() && stack.peek() == popped[j]){
                    stack.pop();
                    j++;
                }
            }
            return stack.isEmpty();
        }
    }
}
