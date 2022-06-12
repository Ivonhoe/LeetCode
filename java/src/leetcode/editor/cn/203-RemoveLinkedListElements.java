package leetcode.editor.cn;

import ivonhoe.java.leetcode.bean.ListNode;

/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] Remove Linked List Elements
 *
 * https://leetcode-cn.com/problems/remove-linked-list-elements/description/
 *
 * algorithms
 * Easy (52.82%)
 * Likes:    929
 * Dislikes: 0
 * Total Accepted:    370.1K
 * Total Submissions: 689.3K
 * Testcase Example:  '[1,2,6,3,4,5,6]\n6'
 *
 * Given the head of a linked list and an integer val, remove all the nodes of
 * the linked list that has Node.val == val, and return the new head.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [], val = 1
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: head = [7,7,7,7], val = 7
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is in the range [0, 10^4].
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode p = new ListNode();
        p.next = head;
        ListNode q = head;
        ListNode ans = p;
        while (q != null) {
            if (q.val == val) {
                p.next = q.next;
            } else {
                p = p.next;
            }
            q = q.next;
        }

        return ans.next;
    }

    // 递归
    private ListNode solution2(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        head.next = solution2(head.next, val);
        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }

}
// @lc code=end
