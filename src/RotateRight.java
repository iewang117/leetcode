public class RotateRight {
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


    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        int len = 1;
        ListNode pt = head;
        while (pt.next != null) {
            pt = pt.next;
            len++;
        }

        pt.next = head;
        int dist = len - k % len;
        while (dist > 0) {
            pt = pt.next;
            dist--;
        }

        ListNode newHead = pt.next;
        pt.next = null;

        return newHead;

    }

}
