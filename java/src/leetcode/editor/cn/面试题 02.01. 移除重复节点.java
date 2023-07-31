import java.util.HashMap;
import java.util.Map;

import ivonhoe.java.leetcode.bean.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();

        ListNode p = head;
        ListNode a = new ListNode();
        ListNode q = a;
        while (p != null) {
            int val = p.val;
            ListNode node = map.get(val);
            if (node == null) {
                map.put(val, p);
                q.next = p;
                q = q.next;
                p = p.next;
                q.next = null;
            } else {
                p = p.next;
            }
        }
        return a.next;
    }
}