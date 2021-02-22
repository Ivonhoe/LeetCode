import leetcode.editor.bean.TreeNode
import java.util.*

//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,1,4,null,2], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 104 
// 0 <= Node.val <= 104 
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
// Related Topics 树 二分查找 
// 👍 348 👎 0


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
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        return solution2(root, k)
    }

    // 进栈计数
    fun solution2(root: TreeNode?, k: Int): Int {
        var stack = LinkedList<TreeNode?>()
        var node = root
        var count = k
        while (true) {
            while (node != null) {
                stack.push(node)
                node = node.left
            }
            node = stack.pop()
            count = count.minus(1)
            if (node == null) {
                return -1
            }
            if (count == 0 && node != null) {
                return node.`val`
            }
            node = node.right
        }
    }

    fun solution1(root: TreeNode?, k: Int): Int {
        if (root == null || k < 1) {
            return -1
        }
        var list = mutableListOf<Int>()
        fun zhongxu(root: TreeNode?) {
            if (root == null) {
                return
            }

            zhongxu(root.left)
            list.add(root.`val`)
            zhongxu(root.right)
        }

        zhongxu(root)
        return list[k - 1]
    }
}
//leetcode submit region end(Prohibit modification and deletion)
