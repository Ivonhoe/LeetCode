import leetcode.editor.bean.ListNode
import leetcode.editor.bean.TreeNode
import java.util.*

//给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
//
// 
//
// 示例： 
//
// 输入：[1,2,3,4,5,null,7,8]
//
//        1
//       /  \ 
//      2    3
//     / \    \ 
//    4   5    7
//   /
//  8
//
//输出：[[1],[2,3],[4,5,7],[8]]
// 
// Related Topics 树 广度优先搜索 
// 👍 42 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
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
    fun listOfDepth(tree: TreeNode?): Array<ListNode?> {
        var ans = mutableListOf<ListNode?>()
        if (tree == null) {
            return ans.toTypedArray()
        }
        var queue = LinkedList<TreeNode?>()
        queue.push(tree)

        var temp = mutableListOf<TreeNode>()
        var head: ListNode? = null
        var p: ListNode? = null

        while (queue.isNotEmpty()) {
            // 尾先出
            var node = queue.pollLast()
            if (head == null) {
                head = ListNode(node!!.`val`)
                p = head
            } else {
                var current = ListNode(node!!.`val`)
                p?.next = current
                p = current
            }

            node?.left?.let { temp.add(it) }
            node?.right?.let { temp.add(it) }

            if (queue.isEmpty()) {
                ans.add(head)
                head = null
            }

            if (queue.isEmpty() && temp.isNotEmpty()) {
                for (item in temp) {
                    // linked list头插法
                    queue.push(item)
                }
                temp.clear()
            }
        }

        return ans.toTypedArray()
    }
}
//leetcode submit region end(Prohibit modification and deletion)
