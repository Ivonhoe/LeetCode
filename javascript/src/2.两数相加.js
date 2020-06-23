/*
 * @lc app=leetcode.cn id=2 lang=javascript
 *
 * [2] 两数相加
 *
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (36.50%)
 * Likes:    3843
 * Dislikes: 0
 * Total Accepted:    314.3K
 * Total Submissions: 861K
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
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
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function (l1, l2) {
    return solution1(l1, l2);
};

var solution1 = function (l1, l2) {
    var value1 = getNumber(l1)
    var value2 = getNumber(l2)
    var value = value1 + value2;

    var array = []
    while (value > 0) {
        array.push(value % 10)
        value = parseInt(value / 10)
    }
}

var getNumber = function (l1) {
    var stack1 = [];
    var value1 = 0;
    do {
        stack1.push(l1.val)
        l1 = l1.next
    } while (l1 != null)

    while (stack1.length > 0) {
        value1 = stack1.pop() + value1 * 10;
    }

    return value1;
}
// @lc code=end

