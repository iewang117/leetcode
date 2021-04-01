import java.util.Stack;

public class Clumsy {
    public int clumsy(int N) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(N--);

        int index = 0;
        while(N>0){
            if(index % 4 == 0){
                stack.push(stack.pop()*N);
            }else if(index % 4 == 1){
                stack.push(stack.pop()/N);
            }else if(index % 4 == 2){
                stack.push(N);
            }else{
                stack.push(-N);
            }
            N--;
            index++;
        }

        int sum = 0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }
}
