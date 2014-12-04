package core;

/**
 * Created by ivonhoe on 14-10-20.
 */
public class SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = new ListNode(-1);
        int step = 0;
        while (p.next != null) {
            if (step % 2 == 0) {
                q.val = p.val;
                q.next = p.next;
                p.val = q.next.val;
                q.next.val = q.val;
            }
            p = p.next;
            step++;
        }

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        int[] samples = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        ListNode head = null;
        ListNode p = null;
        for (int i = 0; i < samples.length; i++) {
            if (p == null) {
                head = new ListNode(samples[i]);
                p = head;
            } else {
                p.next = new ListNode(samples[i]);
                p = p.next;
            }
        }

        swapPairs(head);

        while (head.next != null) {
            System.out.println("---head=" + head.val);
            head = head.next;
        }
        System.out.println("---head=" + head.val);
    }
}
