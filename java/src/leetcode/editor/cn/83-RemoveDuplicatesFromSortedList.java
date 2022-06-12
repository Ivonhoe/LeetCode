package leetcode.editor.cn;

import ivonhoe.java.leetcode.bean.ListNode;

/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * algorithms
 * Easy (53.74%)
 * Likes:    807
 * Dislikes: 0
 * Total Accepted:    441.2K
 * Total Submissions: 823.8K
 * Testcase Example:  '[1,1,2]'
 *
 * Given the head of a sorted linked list, delete all duplicates such that each
 * element appears only once. Return the linked list sorted as well.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,1,2]
 * Output: [1,2]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = new ListNode();
        p.next = head;
        ListNode q = head;
        ListNode ans = p;
        while (q != null) {
            if (q.next != null && q.next.val == q.val) {
                p.next = q.next;
            } else {
                p = p.next;
            }
            q = q.next;
        }
        return ans.next;
    }
}
// @lc code=end
