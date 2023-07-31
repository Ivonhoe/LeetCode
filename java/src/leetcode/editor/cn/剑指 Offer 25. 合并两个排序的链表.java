class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }else if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoListsSolution2(ListNode l1, ListNode l2){
        ListNode p = l1;
        ListNode q = l2;
        ListNode temp = new ListNode();
        ListNode ans = temp;
        while(p!=null && q!=null){
            if(p.val<q.val){
                temp.next = p;
                p = p.next;
            }else{
                temp.next = q;
                q = q.next;
            }
            temp = temp.next;
        }
        while(p!=null){
            temp.next = p;
            p = p.next;
            temp= temp.next;
        }
        while(q!=null){
            temp.next = q;
            q = q.next;
            temp = temp.next;
        }
        return ans.next;
    }
}