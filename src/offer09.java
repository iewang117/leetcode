import java.util.Stack;

public class offer09 {
    class CQueue {
        Stack<Integer> in;
        Stack<Integer> out;

        public CQueue() {
            in = new Stack<Integer>();
            out = new Stack<Integer>();
        }

        public void appendTail(int value) {
            in.push(value);
        }

        public int deleteHead() {
            if(out.isEmpty()){
                while(!in.isEmpty()){
                    out.push(in.pop());
                }
            }

            if(out.isEmpty()){
                return -1;
            }

            return out.pop();
        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
}
