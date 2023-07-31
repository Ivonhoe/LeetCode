/*
 * @lc app=leetcode.cn id=21 lang=javascript
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (64.54%)
 * Likes:    1338
 * Dislikes: 0
 * Total Accepted:    394.4K
 * Total Submissions: 611.1K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
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
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function (l1, l2) {
    return solution2(l1, l2)
};

var solution2 = function (l1, l2) {
    var head = new ListNode(0, null)
    var p = l1,
        q = l2
    var result = head
    while (p != null || q != null) {
        if (p != null && q != null) {
            if (p.val <= q.val) {
                head.next = p
                p = p.next
            } else {
                head.next = q
                q = q.next
            }
        } else if (p == null) {
            head.next = q
            q = q.next
        } else if (q == null) {
            head.next = p
            p = p.next
        }
        head = head.next
    }
    return result.next
}

var solution1 = function (l1, l2) {
    if (l1 == null) {
        return l2
    } else if (l2 == null) {
        return l1
    } else if (l1.val < l2.val) {
        l1.next = solution1(l1.next, l2)
        return l1
    } else {
        l2.next = solution1(l1, l2.next)
        return l2
    }
}
// @lc code=end