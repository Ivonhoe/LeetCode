import leetcode.editor.bean.TreeNode
import java.util.*

//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
//
// 
//
// 示例 1： 
//
// 输入：
//    3
//   / \
//  9  20
//    /  \
//   15   7
//输出：[3, 14.5, 11]
//解释：
//第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
// 
//
// 
//
// 提示： 
//
// 
// 节点值的范围在32位有符号整数范围内。 
// 
// Related Topics 树 
// 👍 242 👎 0


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
class Solution {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        var result = mutableListOf<Double>()
        if (root == null) {
            return result.toDoubleArray()
        }
        var queue = LinkedList<TreeNode>()
        queue.push(root)
        var list = mutableListOf<TreeNode>()
        while (queue.isNotEmpty()) {
            list.addAll(queue)
            queue.clear()
            var sum = 0.0
            for (i in 0 until list.size) {
                var item = list[i]
                sum += item.`val`
                if (item.left != null) {
                    queue.add(item.left!!)
                }
                if (item.right != null) {
                    queue.add(item.right!!)
                }
            }
            result.add((sum / list.size))
            list.clear()
        }

        return result.toDoubleArray()
    }
}
//leetcode submit region end(Prohibit modification and deletion)
