import leetcode.editor.bean.TreeNode
import java.util.*
import kotlin.collections.ArrayList

//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
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
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 415 👎 0


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
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        return solution2(root)
    }

    fun solution2(root: TreeNode?): List<List<Int>> {
        var result = mutableListOf<ArrayList<Int>>()
        dfs(root, result, 0)
        result.reverse()
        return result
    }

    fun dfs(root: TreeNode?, res: MutableList<ArrayList<Int>>, level: Int) {
        if (root == null)
            return
        if (level >= res.size) {
            var list = mutableListOf<Int>()
            res.add(list as ArrayList<Int>)
        }

        res[level].add(root.`val`)
        dfs(root.left, res, level + 1)
        dfs(root.right, res, level + 1)
    }

    // 层序遍历
    fun solution1(root: TreeNode?): List<List<Int>> {
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
            result.add(0, level)
            list.clear()
        }

        return result
    }
}
//leetcode submit region end(Prohibit modification and deletion)
