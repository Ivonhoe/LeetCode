//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 846 👎 0

import leetcode.editor.bean.TreeNode
import java.util.*
import kotlin.collections.ArrayList

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
    /**
     * 中序遍历使用递归或dfs
     */
    fun inorderTraversal(root: TreeNode?): List<Int> {
        return solution2(root)
    }

    // dfs遍历
    fun solution2(root: TreeNode?): List<Int> {
        var result = ArrayList<Int>()
        var stack = LinkedList<TreeNode>()

        var cur = root
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur)
                cur = cur.left
            } else {
                var nod = stack.pop()
                result.add(nod.`val`)
                cur = nod.right
            }
        }

        return result
    }

    // 递归
    fun solution1(root: TreeNode?): List<Int> {
        var result = ArrayList<Int>()

        fun inOrder(root: TreeNode?) {
            if (root == null) {
                return
            }
            inOrder(root.left)
            result.add(root.`val`)
            inOrder(root.right)
        }

        inOrder(root)
        return result
    }
}
//leetcode submit region end(Prohibit modification and deletion)
