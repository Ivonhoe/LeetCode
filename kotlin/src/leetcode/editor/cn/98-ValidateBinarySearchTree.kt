import leetcode.editor.bean.TreeNode

//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 920 👎 0


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

    fun isValidBST(root: TreeNode?): Boolean {
        return solution2(root, null, null)
    }

    // 非递归实现
//    fun solution2(root: TreeNode?): Boolean {
//        var stack = Stack()
//
//        return false
//    }

    // 递归实现
    // 二叉搜索树，中序遍历是升序的，所以检查前一个节点和当前节点的大小
    var pre: Long = Long.MIN_VALUE
    fun solution1(root: TreeNode?): Boolean {
        if (root?.`val` == null) {
            return true
        }
        if (!solution1(root.left)) {
            return false
        }
        if (root.`val` <= pre) {
            return false
        }
        pre = root.`val`.toLong()

        return solution1(root.right)
    }

    // 前序遍历
    fun solution2(root: TreeNode?, min: TreeNode?, max: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        if (min != null && root.`val` <= min.`val`) {
            return false
        }
        if (max != null && root.`val` >= max.`val`) {
            return false
        }
        return solution2(root.left, min, root) && solution2(root.right, root, max)
    }
}
//leetcode submit region end(Prohibit modification and deletion)
