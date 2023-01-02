package leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.Queue;

import ivonhoe.java.leetcode.bean.ListNode;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (56.51%)
 * Likes:    2284
 * Dislikes: 0
 * Total Accepted:    584.7K
 * Total Submissions: 1M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted
 * in ascending order.
 * 
 * Merge all the linked-lists into one sorted linked-list and return it.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * ⁠ 1->4->5,
 * ⁠ 1->3->4,
 * ⁠ 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: lists = []
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: lists = [[]]
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 10^4.
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
    // 没有AC的
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);

        for (ListNode node : lists) {
            ListNode n = node;
            while (n != null) {
                pq.offer(n);
                n = n.next;
            }
        }

        ListNode ans = new ListNode();
        ListNode p = ans;
        while (!pq.isEmpty()) {
            ListNode tail = pq.poll();
            p.next = tail;
            p = tail;
            tail.next = null;
        }

        return ans.next;
    }
}
// @lc code=end
