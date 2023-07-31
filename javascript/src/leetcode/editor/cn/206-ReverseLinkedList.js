/*
 * @lc app=leetcode.cn id=206 lang=javascript
 *
 * [206] 反转链表
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (69.45%)
 * Likes:    1047
 * Dislikes: 0
 * Total Accepted:    266.7K
 * Total Submissions: 383.6K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 反转一个单链表。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function (head) {
    // result = null
    // p = null
    // solution1(head)
    // return result
    return solution2(head)
};

var result = null
var p = null

function solution1(head) {
    if (!head) {
        return null
    }

    solution1(head.next)
    if (result == null) {
        result = new ListNode(head.val)
        p = result;
    } else {
        var node = new ListNode(head.val)
        p.next = node
        p = p.next
    }
}

function solution2(head) {
    var pre = null,
        current = head;
    while (current) {
        var t = current.next;
        current.next = pre;
        pre = current;
        current = t;
    }

    return pre
}
// @lc code=end