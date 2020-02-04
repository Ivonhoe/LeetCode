package ivonhoe.java.leetcode.core;

import ivonhoe.java.leetcode.bean.ListNode;

import java.util.Stack;

/**
 * Created by ivonhoe on 14-10-30.
 */
public class RemoveDuplicatesFromSortedList2 {

    // 使用栈？
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        Stack stack = new Stack();
        ListNode p = head;
        int current = Integer.MAX_VALUE;
        while (p != null) {
            if(stack.isEmpty()){
                if(current==p.val){

                }
            }else {

            }
        }

        return head;
    }
}
