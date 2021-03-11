import leetcode.editor.bean.TreeNode
import java.util.*

//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 801 👎 0


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
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        var result = mutableListOf<List<Int>>()
        if (root == null) {
            return result
        }
        var queue = LinkedList<TreeNode>()
        queue.push(root)
        var list = mutableListOf<TreeNode>()
        while (queue.isNotEmpty()) {
            list.addAll(queue)
            queue.clear()
            var level = mutableListOf<Int>()
            for (item in list) {
                level.add(item.`val`)
                if (item.left != null) {
                    queue.add(item.left!!)
                }
                if (item.right != null) {
                    queue.add(item.right!!)
                }
            }
            result.add(level)
            list.clear()
        }

        return result
    }
}
//leetcode submit region end(Prohibit modification and deletion)
