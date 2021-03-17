import java.util.Stack;

public class offer06 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int[] reversePrint(ListNode head) {
            Stack<Integer> stack = new Stack<Integer>();
            int count = 0;

            while (head != null) {
                int element = head.val;
                stack.push(element);
                head = head.next;
                count++;
            }
            int[] array = new int[count];
            for (int i = 0; i < count; i++) {
                array[i] = stack.pop();
            }
            return array;
        }
    }
}
