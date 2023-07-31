/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = head;
        ListNode q = head;
        while(q!=null){
            if(k>0){
                k--;
            }else{
                p = p.next;
            }
            q = q.next;
        }
        return p;
    }
}