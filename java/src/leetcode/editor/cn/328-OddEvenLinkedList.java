package leetcode.editor.cn;

import ivonhoe.java.leetcode.bean.ListNode;

/*
 * @lc app=leetcode.cn id=328 lang=java
 *
 * [328] Odd Even Linked List
 *
 * https://leetcode-cn.com/problems/odd-even-linked-list/description/
 *
 * algorithms
 * Medium (65.47%)
 * Likes:    595
 * Dislikes: 0
 * Total Accepted:    165.5K
 * Total Submissions: 253.1K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Given the head of a singly linked list, group all the nodes with odd indices
 * together followed by the nodes with even indices, and return the reordered
 * list.
 * 
 * The first node is considered odd, and the second node is even, and so on.
 * 
 * Note that the relative order inside both the even and odd groups should
 * remain as it was in the input.
 * 
 * You must solve the problem in O(1) extra space complexity and O(n) time
 * complexity.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [2,1,3,5,6,4,7]
 * Output: [2,3,6,7,1,5,4]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the linked list is in the range [0, 10^4].
 * -10^6 <= Node.val <= 10^6
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;

        ListNode other = new ListNode();
        ListNode k = other;
        while (p != null && q != null) {
            ListNode n = p.next;
            p.next = q.next;
            other.next = q;
            q.next = null;
            p = p.next;
            if (p != null) {
                q = p.next;
            } else {
                break;
            }
            other = other.next;
        }
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = k.next;
        return head;
    }
}
// @lc code=end
