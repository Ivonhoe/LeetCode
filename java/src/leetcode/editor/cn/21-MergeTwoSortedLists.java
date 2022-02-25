import ivonhoe.java.leetcode.bean.ListNode;

/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (66.70%)
 * Likes:    2210
 * Dislikes: 0
 * Total Accepted:    873.5K
 * Total Submissions: 1.3M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 * 
 * Merge the two lists in a one sorted list. The list should be made by
 * splicing together the nodes of the first two lists.
 * 
 * Return the head of the merged linked list.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: list1 = [], list2 = []
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoListsSolution2(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode temp = new ListNode();
        ListNode ans = temp;
        while (p != null && q != null) {
            if (p.val < q.val) {
                temp.next = p;
                p = p.next;
            } else {
                temp.next = q;
                q = q.next;
            }
            temp = temp.next;
        }
        while (p != null) {
            temp.next = p;
            p = p.next;
            temp = temp.next;
        }
        while (q != null) {
            temp.next = q;
            q = q.next;
            temp = temp.next;
        }
        return ans.next;
    }
}
// @lc code=end
