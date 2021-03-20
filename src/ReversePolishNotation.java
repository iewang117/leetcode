import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            //是数字
            if (!(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))) {
                //解析数字
                stack.push(Integer.parseInt(token));
            } else {
                //是符号
                //右操作数
                int num2 = stack.pop();
                //左操作数
                int num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
