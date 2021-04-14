import leetcode.editor.bean.TreeNode
import kotlin.math.min

//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
//
// 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bs
//t/ 相同 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 100] 内 
// 0 <= Node.val <= 105 
// 差值是一个正数，其数值等于两值之差的绝对值 
// 
// 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 182 👎 0


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
    var pre = -1
    var ans = Int.MAX_VALUE

    fun minDiffInBST(root: TreeNode?): Int {
        // 中序遍历
        fun inOrder(node: TreeNode?) {
            if (node == null) {
                return
            }
            inOrder(node.left)
            if (pre == -1) {
                pre = node.`val`
            } else {
                ans = Math.min(node.`val` - pre, ans)
                pre = node.`val`
            }
            inOrder(node.right)
        }
        inOrder(root)
        return ans
    }


}
//leetcode submit region end(Prohibit modification and deletion)
