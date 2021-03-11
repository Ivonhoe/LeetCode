import leetcode.editor.bean.TreeNode
import java.util.*

//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 406 👎 0


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
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        var result = mutableListOf<List<Int>>()
        if (root == null) {
            return result
        }
        var queue = LinkedList<TreeNode>()
        queue.push(root)
        var list = mutableListOf<TreeNode>()
        var flag = true
        while (queue.isNotEmpty()) {
            list.addAll(queue)
            queue.clear()
            var level = mutableListOf<Int>()
            for (item in list) {
                if (flag) {
                    level.add(item.`val`)
                } else {
                    level.add(0, item.`val`)
                }
                if (item.left != null) {
                    queue.add(item.left!!)
                }
                if (item.right != null) {
                    queue.add(item.right!!)
                }
            }

            result.add(level)
            flag = !flag
            list.clear()
        }

        return result
    }
}
//leetcode submit region end(Prohibit modification and deletion)
