import ivonhoe.java.leetcode.bean.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode p = new ListNode(-1);
        p.next = head;
        ListNode q = p;
        ListNode ans = p;
        while(q.next!=null){
            q = q.next;
            if(q.val==val){
                p.next = q.next;
                q = p;
            }else{
                p = p.next;
            }
        }
        return ans.next;
    }
}