package core;

/**
 * Created by ivonhoe on 14-10-23.
 */
public class LinkedListCycle {

    // faster pointer move two steps one time,slower pointer move one step one time,
    // if has cycle,faster will finally catch slower
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }

        }
        return false;
    }

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

    }
}
