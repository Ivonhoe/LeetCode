import leetcode.editor.bean.TreeNode
import java.util.*

//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 递归 队列 
// 👍 421 👎 0


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
    fun rightSideView(root: TreeNode?): List<Int> {
        return solution2(root)
    }

    fun solution1(root: TreeNode?): List<Int> {
        var result = mutableListOf<Int>()
        if (root == null) {
            return result
        }
        var queue = LinkedList<TreeNode>()
        queue.push(root)
        var list = mutableListOf<TreeNode>()
        while (queue.isNotEmpty()) {
            list.addAll(queue)
            queue.clear()
            for (i in 0 until list.size) {
                var item = list[i]
                if (item.left != null) {
                    queue.add(item.left!!)
                }
                if (item.right != null) {
                    queue.add(item.right!!)
                }
                if (i == list.size - 1) {
                    result.add(item.`val`)
                }
            }
            list.clear()
        }

        return result
    }

    fun solution2(root: TreeNode?): List<Int> {
        var result = mutableListOf<Int>()
        dfs(root, result, 0)
        return result
    }

    fun dfs(root: TreeNode?, result: MutableList<Int>, depth: Int) {
        if (root == null) {
            return
        }
        // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
        if (depth == result.size) {
            result.add(root.`val`)
        }

        dfs(root.right, result, depth + 1)
        dfs(root.left, result, depth + 1)
    }
}
//leetcode submit region end(Prohibit modification and deletion)
