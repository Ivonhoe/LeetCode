/*
 * @lc app=leetcode.cn id=876 lang=javascript
 *
 * [876] 链表的中间结点
 *
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/description/
 *
 * algorithms
 * Easy (69.53%)
 * Likes:    271
 * Dislikes: 0
 * Total Accepted:    79.6K
 * Total Submissions: 114.5K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 
 * 如果有两个中间结点，则返回第二个中间结点。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next
 * = NULL.
 * 
 * 
 * 示例 2：
 * 
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 给定链表的结点数介于 1 和 100 之间。
 * 
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
var middleNode = function (head) {
    return solution2(head)
};

// 快慢指针，一个一次走一步，一个一次走两步
var solution2 = function (head) {
    var p = head
    var q = head
    while (q != null && q.next != null) {
        p = p.next
        q = q.next.next
    }

    return p
}

var solution1 = function (head) {
    var p = head;
    var length = 0
    while (p != null) {
        p = p.next
        length++
    }

    var middle = length % 2 == 0 ? length / 2 : length / 2 - 1
    var q = head
    var index = 0
    while (index < middle) {
        q = q.next
        index++
    }

    return q
}
// @lc code=end