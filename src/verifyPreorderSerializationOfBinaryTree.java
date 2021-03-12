import java.util.Stack;

public class verifyPreorderSerializationOfBinaryTree {
    class Solution {
        public boolean isValidSerialization(String preorder) {
            int n = preorder.length();
            int i = 0;
            Stack<Integer> stack = new Stack<Integer>();
            stack.push(1);
            while(i < n){
                //提前为空
                if(stack.isEmpty()){
                    return false;
                }
                //读到逗号
                if(preorder.charAt(i) == ','){
                    i++;
                    //读到井号
                }else if(preorder.charAt(i) == '#'){
                    int top = stack.pop() - 1;
                    if(top > 0){
                        stack.push(top);
                    }
                    i++;
                    //读到数字
                }else{
                    //处理2位以上的数字
                    while (i < n && preorder.charAt(i) != ',') {
                        i++;
                    }
                    int top = stack.pop() - 1;
                    if(top > 0){
                        stack.push(top);
                    }
                    stack.push(2);
                    i++;
                }
            }
            return stack.isEmpty();
        }
    }
}
