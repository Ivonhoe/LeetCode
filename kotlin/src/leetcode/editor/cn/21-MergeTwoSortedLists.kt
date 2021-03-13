import leetcode.editor.bean.ListNode

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1596 👎 0


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
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        return solution2(l1, l2)
    }

    fun solution2(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) {
            return l2
        } else if (l2 == null) {
            return l1
        } else if (l1.`val` < l2.`val`) {
            l1.next = solution2(l1.next, l2)
            return l1
        } else {
            l2.next = solution2(l1, l2.next)
            return l2
        }
    }

    // 迭代
    fun solution1(l1: ListNode?, l2: ListNode?): ListNode? {
        var head: ListNode? = ListNode(-1)
        var p = l1
        var q = l2
        var result = head
        while (p != null && q != null) {
            if (p.`val` < q.`val`) {
                head?.next = p
                p = p.next
            } else {
                head?.next = q
                q = q.next
            }
            head = head?.next
        }

        if (p != null) {
            head?.next = p
        } else {
            head?.next = q
        }

        return result?.next
    }
}
//leetcode submit region end(Prohibit modification and deletion)
