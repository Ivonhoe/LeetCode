/**
 * Created by ivonhoe on 14-10-20.
 */
public class ReverseNodesInkGroup {

//    public static ListNode reverseKGroup(ListNode head, int k) {
//        if (head == null || k < 2) {
//            return head;
//        }
//        int[] temp = new int[k];
//        int step = 0;
//        ListNode p = head;
//        ListNode q = head;
//        temp[0] = head.val;
//
//        while (p != null) {
//            int i = step++ % k;
//            temp[i] = p.val;
//            System.out.println("--temp,i=" + i + ",temp[i]=" + temp[i]);
//
//            if (step % k == 0) {
//                int j = i;
//                while (j >= 0) {
//                    q.val = temp[j--];
//                    q = q.next;
//                }
//            }
//            p = p.next;
//        }
//        return head;
//    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }
        int[] temp = new int[k];
        int step = 0;
        ListNode p = head;
        ListNode q = head;

        while (p != null) {
            int i = step++ % k;
            temp[i] = p.val;

            if (i == k - 1) {
                int j = i;
                while (q != null && j >= 0) {
                    q.val = temp[j--];
                    q = q.next;
                }
            }

            p = p.next;
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
        int[] samples = { 1, 2, 3, 4, 5, 6, 7, 8,9 };
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

        reverseKGroup(head, 6);

        while (head != null) {
            System.out.println("---head=" + head.val);
            head = head.next;
        }
    }
}
