/*
 * @lc app=leetcode.cn id=143 lang=javascript
 *
 * [143] 重排链表
 *
 * https://leetcode-cn.com/problems/reorder-list/description/
 *
 * algorithms
 * Medium (59.42%)
 * Likes:    423
 * Dislikes: 0
 * Total Accepted:    64.3K
 * Total Submissions: 108.3K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 示例 1:
 * 
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 
 * 示例 2:
 * 
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
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
 * @return {void} Do not return anything, modify head in-place instead.
 */
var reorderList = function (head) {
    return solution2(head)
};

var solution2 = function (head) {
    if (head == null) {
        return null
    }

    // 找到中点
    var middle = middleNode(head)
    var newHead = middle.next
    // 将前半部截断
    middle.next = null
    // 翻转链表
    newHead = reverseList(newHead)

    //链表节点依次连接
    while (newHead != null) {
        var temp = newHead.next;
        newHead.next = head.next;
        head.next = newHead;
        head = newHead.next;
        newHead = temp;
    }
}

var middleNode = function (head) {
    var p = head
    var q = head
    while (q != null && q.next != null) {
        p = p.next
        q = q.next.next
    }

    return p
}

// 翻转列表
var reverseList = function (head) {
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

// 线性表，先存起来，再重建,
// 时间复杂度O(n),空间复杂度O(n)
var solution1 = function (head) {
    if (head == null) {
        return null
    }

    var list = []
    var p = head
    while (p != null) {
        list.push(p)
        p = p.next
    }

    for (var i = 0, j = list.length - 1; i < j;) {
        list[i].next = list[j]
        i++
        if (i == j) {
            break
        }
        list[j].next = list[i]
        j--
    }
    list[i].next = null

    return list[0]
};
// @lc code=end