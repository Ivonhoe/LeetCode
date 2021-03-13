import leetcode.editor.bean.ListNode

//反转一个单链表。
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1570 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        return solution2(head)
    }

    fun solution2(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var current: ListNode? = head

        while (current != null) {
            var next = current.next
            current.next = prev
            prev = current
            current = next
        }

        return prev
    }

    // 递归
    fun solution1(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        var p = solution1(head.next)
        head?.next?.next = head
        head.next = null
        return p
    }
}
//leetcode submit region end(Prohibit modification and deletion)
