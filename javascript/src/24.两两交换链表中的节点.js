/*
 * @lc app=leetcode.cn id=24 lang=javascript
 *
 * [24] 两两交换链表中的节点
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (68.04%)
 * Likes:    712
 * Dislikes: 0
 * Total Accepted:    181.7K
 * Total Submissions: 267.1K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：head = [1]
 * 输出：[1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 **/
var swapPairs = function (head) {
    return solution2(head)
};

// 递归解法
var solution2 = function (head) {
    if (head == null || head.next == null) {
        return head
    }

    var next = head.next
    // 使head指向后面交换后的结点
    head.next = solution2(next.next)
    // 第二个结点指向head
    next.next = head
    // 返回新的头结点
    return next
}

var solution1 = function (head) {
    var h = new ListNode(0)
    h.next = head
    var temp = h
    while (temp.next != null && temp.next.next != null) {
        var pre = temp;
        var mid = temp.next
        var next = temp.next.next

        pre.next = next
        mid.next = next.next
        next.next = mid

        temp = mid
    }

    return h.next
}
// @lc code=end