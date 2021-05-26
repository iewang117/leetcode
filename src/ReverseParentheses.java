import java.util.Stack;

public class ReverseParentheses {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        StringBuffer s2 = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(s2.toString());
                s2.setLength(0);
            } else if (c == ')') {
                s2.reverse();
                s2.insert(0, stack.pop());
            } else {
                s2.append(c);
            }
        }
        return s2.toString();
    }
}
