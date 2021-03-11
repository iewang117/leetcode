public class reverseLinkedList2 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == 1) {
                return reverseN(head, right);
            }

            head.next = reverseBetween(head.next, left - 1, right - 1);
            return head;
        }

        ListNode successor = null;

        public ListNode reverseN(ListNode head, int right) {
            if (right == 1) {
                successor = head.next;
                return head;
            }

            ListNode last = reverseN(head.next, right - 1);

            head.next.next = head;
            head.next = successor;

            return last;
        }
    }
}