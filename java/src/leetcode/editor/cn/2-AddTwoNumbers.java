package leetcode.editor.cn;

import ivonhoe.java.leetcode.bean.ListNode;

/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (41.37%)
 * Likes:    8182
 * Dislikes: 0
 * Total Accepted:    1.4M
 * Total Submissions: 3.3M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have
 * leading zeros.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int length1 = getLength(l1);
        int length2 = getLength(l2);

        ListNode p = l1;
        ListNode q = l2;
        if (length1 < length2) {
            p = addZero(l1, length2 - length1);
        } else if (length1 > length2) {
            q = addZero(l2, length1 - length2);
        }

        int plus = 0;
        ListNode node = new ListNode();
        ListNode ans = node;
        while (p != null && q != null) {
            int sum = plus + p.val + q.val;
            if (sum >= 10) {
                plus = 1;
            } else {
                plus = 0;
            }
            q = q.next;
            p = p.next;

            ListNode n = new ListNode(sum % 10);
            node.next = n;
            node = node.next;
        }
        if (plus > 0) {
            ListNode n = new ListNode(plus);
            node.next = n;
        }

        return ans.next;
    }

    private ListNode addZero(ListNode node, int count) {
        ListNode ans = node;
        while (node.next != null) {
            node = node.next;
        }
        while (count > 0) {
            node.next = new ListNode(0);
            node = node.next;
            count--;
        }
        return ans;
    }

    private int getLength(ListNode l) {
        int length = 0;
        ListNode p = l;
        while (p != null) {
            p = p.next;
            length++;
        }

        return length;
    }
}
// @lc code=end
