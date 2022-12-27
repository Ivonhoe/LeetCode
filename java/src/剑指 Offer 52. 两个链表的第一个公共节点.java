import ivonhoe.java.leetcode.bean.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = 0, bLength = 0;
        ListNode p = headA;
        ListNode q = headB;
        while(p!=null) {
            aLength++;
            p = p.next;
        }
        while(q!=null){
            bLength++;
            q = q.next;
        }

        if(aLength>bLength){
            p = headA;
            q = headB;
        }else{
            p = headB;
            q = headA;
        }

        int count = Math.abs(aLength-bLength);
        while(p!=null && q!=null){
            if(count>0){
                count--;
                p = p.next;
                continue;
            }
            if(p == q){
                return p;
            }
            p = p.next;
            q = q.next;
        }

        return null;
    }
}