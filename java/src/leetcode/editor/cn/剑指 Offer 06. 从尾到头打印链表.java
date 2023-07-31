/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        List<Integer> result = new ArrayList();
        reverse(head, result);
        int[] ans = new int[result.size()];
        int i=0;
        for(Integer k:result){
            ans[i++]= k;
        }
        return ans;
    }

    private void reverse(ListNode head, List<Integer> result){
        if(head == null){
            return;
        }
        reverse(head.next, result);
        result.add(head.val);
    }
}